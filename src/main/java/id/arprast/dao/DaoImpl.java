package id.arprast.dao;

import id.arprast.dto.RequestData;
import id.arprast.http.request.MemberRequest;
import id.arprast.http.request.TransactionRequest;
import id.arprast.model.MemberModel;
import id.arprast.model.TransactionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ari-prasetiyo
 */
@Repository
public class DaoImpl {

    private static final String QUERY_GET_MEMBER = "select id, name, address, date_of_birth  from alami_member";
    private static final String QUERY_INSERT_MEMBER = "insert into alami_member(name, address, date_of_birth) values (?,?, ?) returning  id, name, address, date_of_birth  ";
    private static final String QUERY_INSERT_TRANSACTION = "insert into alami_transaction(member_id, trx_type, amount,currency, trx_date ) values (?,?, ?, ?, ?)  returning id transaction_id, member_id, trx_type, amount, currency, trx_date ";
    private static final String QUERY_GET_TRANSACTION_BY_DATE =
            new StringBuilder("select at.id as transaction_id, name, member_id, trx_type, amount, currency, trx_date from ")
                    .append("alami_transaction  at left join alami_member am on at.member_id = am.id where at.trx_date between ? and ?").toString();
    private static final String QUERY_GET_TRANSACTION_BY_MEMBER =
            new StringBuilder("select at.id as transaction_id, name, member_id, trx_type, amount, currency, trx_date from ")
                    .append("alami_transaction  at inner join alami_member am on at.member_id = am.id where member_id= ? and name = ? ").toString();

    @Autowired
    @PersistenceContext
    EntityManager em;

    public List<MemberModel> getMembers() {
        return em.createNativeQuery(QUERY_GET_MEMBER, "MemberModelMapper")
                .getResultList();
    }

    public MemberModel insertMember(MemberRequest memberRequest) {
        return (MemberModel) em.createNativeQuery(QUERY_INSERT_MEMBER, "MemberModelMapper")
                .setParameter(1, memberRequest.getName() )
                .setParameter(2, memberRequest.getAddress() )
                .setParameter(3, memberRequest.getBirthOfDate())
                .getSingleResult();
    }

    public TransactionModel insertTransaction(TransactionRequest request) {
        return (TransactionModel) em.createNativeQuery(QUERY_INSERT_TRANSACTION, "TransactionModelMapper")
                .setParameter(1, request.getMemberId() )
                .setParameter(2, request.getTransactionType().id )
                .setParameter(3, request.getAmount())
                .setParameter(4, request.getCurrency())
                .setParameter(5, request.getDate())
                .getSingleResult();
    }

    public List<TransactionModel> getTransactionByDate(RequestData request) {
        return em.createNativeQuery(QUERY_GET_TRANSACTION_BY_DATE, "TransactionModelByDateMapper")
                .setParameter(1, request.getStartDate())
                .setParameter(2, request.getEndDate())
                .getResultList();
    }

    public List<TransactionModel> getTransactionByMember(RequestData request) {
        return em.createNativeQuery(QUERY_GET_TRANSACTION_BY_MEMBER, "TransactionModelByDateMapper")
                .setParameter(1, request.getMemberId())
                .setParameter(2, request.getName())
                .getResultList();
    }
}
