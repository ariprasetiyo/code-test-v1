package id.arprast.dao;

import id.arprast.model.MemberModel;
import id.arprast.model.TransactionModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alami_member")
@SqlResultSetMapping(name = "MemberModelMapper",
        classes = {
                @ConstructorResult(
                        targetClass = MemberModel.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "address", type = String.class),
                                @ColumnResult(name = "date_of_birth", type = Date.class)
                        })
        })

@SqlResultSetMapping(name = "TransactionModelMapper",
        classes = {
                @ConstructorResult(
                        targetClass = TransactionModel.class,
                        columns = {
                                @ColumnResult(name = "transaction_id", type = Long.class),
                                @ColumnResult(name = "member_id", type = Long.class),
                                @ColumnResult(name = "trx_type", type = String.class),
                                @ColumnResult(name = "amount", type = Double.class),
                                @ColumnResult(name = "currency", type = String.class),
                                @ColumnResult(name = "trx_date", type = Date.class)
                        })
        })

@SqlResultSetMapping(name = "TransactionModelByDateMapper",
        classes = {
                @ConstructorResult(
                        targetClass = TransactionModel.class,
                        columns = {
                                @ColumnResult(name = "transaction_id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "member_id", type = Long.class),
                                @ColumnResult(name = "trx_type", type = String.class),
                                @ColumnResult(name = "amount", type = Double.class),
                                @ColumnResult(name = "currency", type = String.class),
                                @ColumnResult(name = "trx_date", type = Date.class)
                        })
        })


public class ModelMapper {

    @Id
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
