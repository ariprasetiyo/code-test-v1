package id.arprast.service;

import id.arprast.dao.DaoImpl;
import id.arprast.dto.RequestData;
import id.arprast.dto.ResponseData;
import id.arprast.http.Request;
import id.arprast.http.Response;
import id.arprast.http.request.MemberRequest;
import id.arprast.http.request.TransactionRequest;
import id.arprast.model.MemberModel;
import id.arprast.model.TransactionModel;
import id.arprast.ref.StatusCode;
import id.arprast.util.LogUtil;
import id.arprast.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlamiService extends LogUtil {

    private static final Logger logger = LoggerFactory.getLogger(AlamiService.class);

    @Autowired
    DaoImpl daoImpl;

    public final ResponseEntity<Response> getMembers(final Request<RequestData> request) {
        final Response responseDto = Util.buildResponse(request);
        final List<MemberModel> members = getMembersData();
        final ResponseData responseData = new ResponseData();
        responseData.setTotalRecord(members.size());
        responseData.setData(members);
        responseDto.setResponseData(responseData);
        responseDto.setStatusCode(responseData.getStatusCode() == null ? StatusCode.SUCCESS : responseData.getStatusCode());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public final ResponseEntity<Response> addMember(final Request<MemberRequest> request) {
        final Response responseDto = Util.buildResponse(request);
        final ResponseData responseData = new ResponseData();
        if(request.getRequestData().getName().length() > 2){
            final MemberModel member = addMember(request.getRequestData());
            responseData.setTotalRecord(1);
            responseData.setData(member);
        }else{
            responseData.setStatusCode(StatusCode.MINIMUN_NAME_THREE_CHAR);
            responseData.setTotalRecord(0);
        }
        responseDto.setResponseData(responseData);
        responseDto.setStatusCode(responseData.getStatusCode() == null ? StatusCode.SUCCESS : responseData.getStatusCode());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public final ResponseEntity<Response> addTransaction(final Request<TransactionRequest> request) {
        final Response responseDto = Util.buildResponse(request);
        final TransactionRequest transactionRequest = request.getRequestData();
        final ResponseData responseData = new ResponseData();
        if(transactionRequest.getAmount() > 0){
            final TransactionModel result = addTransaction(transactionRequest);
            responseData.setTotalRecord(1);
            responseData.setData(result);
        }else{
            responseData.setStatusCode(StatusCode.AMOUNT_NEGATIVE);
            responseData.setTotalRecord(0);
        }

        responseDto.setResponseData(responseData);
        responseDto.setStatusCode(responseData.getStatusCode() == null ? StatusCode.SUCCESS : responseData.getStatusCode());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public final ResponseEntity<Response> getTransactionByDate(final Request<RequestData> request) {
        final Response responseDto = Util.buildResponse(request);
        final List<TransactionModel> results = getTransactionByDate(request.getRequestData());
        final ResponseData responseData = new ResponseData();
        responseData.setTotalRecord(results.size());
        responseData.setData(results);
        responseDto.setResponseData(responseData);
        responseDto.setStatusCode(results.size() == 0 ? StatusCode.NOT_FOUND : StatusCode.SUCCESS);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public final ResponseEntity<Response> getTransactionByMember(final Request<RequestData> request) {
        final Response responseDto = Util.buildResponse(request);
        final List<TransactionModel> results = getTransactionByMember(request.getRequestData());
        final ResponseData responseData = new ResponseData();
        responseData.setTotalRecord(results.size());
        responseData.setData(results);
        responseDto.setResponseData(responseData);
        responseDto.setStatusCode(results.size() == 0 ? StatusCode.NOT_FOUND : StatusCode.SUCCESS);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    private TransactionModel addTransaction(TransactionRequest request) {
        return daoImpl.insertTransaction(request);
    }

    private List<MemberModel> getMembersData() {
        return daoImpl.getMembers();
    }

    private MemberModel addMember(MemberRequest request) {
        return daoImpl.insertMember(request);
    }

    private List<TransactionModel> getTransactionByDate(RequestData request) {
        return daoImpl.getTransactionByDate(request);
    }

    private List<TransactionModel> getTransactionByMember(RequestData request) {
        return daoImpl.getTransactionByMember(request);
    }

}
