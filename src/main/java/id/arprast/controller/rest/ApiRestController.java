package id.arprast.controller.rest;

import id.arprast.dto.RequestData;
import id.arprast.http.Request;
import id.arprast.http.Response;
import id.arprast.http.request.MemberRequest;
import id.arprast.http.request.TransactionRequest;
import id.arprast.service.AlamiService;
import id.arprast.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ApiRestController {

    @Autowired
    AlamiService alamiService;

    @RequestMapping(value = "/alami/member/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public final ResponseEntity<Response> getMembers() {
        return LogUtil.logResponse(alamiService.getClass(), alamiService.getMembers(initRequest(alamiService.getClass(), new Request<>())));
    }

    @RequestMapping(value = "/alami/member/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public final ResponseEntity<Response> addMember(@RequestBody @Valid final Request<MemberRequest> request) {
        return LogUtil.logResponse(alamiService.getClass(), alamiService.addMember(initRequest(alamiService.getClass(), request)));
    }

    @RequestMapping(value = "/alami/transaction/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public final ResponseEntity<Response> addTransaction(@RequestBody @Valid final Request<TransactionRequest> request) {
        return LogUtil.logResponse(alamiService.getClass(), alamiService.addTransaction(initRequest(alamiService.getClass(), request)));
    }

    @RequestMapping(value = "/alami/transaction/get/history", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public final ResponseEntity<Response> getTransactionHistory(@RequestBody @Valid final Request<RequestData> request) {
        return LogUtil.logResponse(alamiService.getClass(), alamiService.getTransactionByDate(initRequest(alamiService.getClass(), request)));
    }

    @RequestMapping(value = "/alami/transaction/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public final ResponseEntity<Response> getTransaction(@RequestBody @Valid final Request<RequestData> masterItemRequest) {
        return LogUtil.logResponse(alamiService.getClass(), alamiService.getTransactionByMember(initRequest(alamiService.getClass(), masterItemRequest)));
    }

    private static Request initRequest(final Class aClass, final Request request) {
        LogUtil.logRequest(aClass, request);
        return request;
    }

}
