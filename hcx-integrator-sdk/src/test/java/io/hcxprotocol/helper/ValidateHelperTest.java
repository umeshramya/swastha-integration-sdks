package io.hcxprotocol.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.hcxprotocol.utils.JSONUtils;
import io.hcxprotocol.utils.Operations;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateHelperTest {

    protected Map<String,Object> getRequestBody() {
        return Collections.singletonMap("payload","eyJlbmMiOiJBMjU2R0NNIiwKImFsZyI6IlJTQS1PQUVQIiwKIngtaGN4LXNlbmRlcl9jb2RlIjoiMS0zYTNiZDY4YS04NDhhLTRkNTItOWVjMi0wN2E5MmQ3NjVmYjQiLAoieC1oY3gtcmVjaXBpZW50X2NvZGUiOiIxLWNlMjNjY2RjLWU2NDUtNGUzNS05N2I4LTBiZDhmZWY0M2VjZCIsCiJ4LWhjeC1hcGlfY2FsbF9pZCI6IjI2YjEwNjBjLTFlODMtNDYwMC05NjEyLWVhMzFlMGNhNTA5MyIsCiJ4LWhjeC1jb3JyZWxhdGlvbl9pZCI6IjVlOTM0ZjkwLTExMWQtNGYwYi1iMDE2LWMyMmQ4MjA2NzRlMSIsCiJ4LWhjeC10aW1lc3RhbXAiOiIyMDIxLTEwLTI3VDIwOjM1OjUyLjYzNiswNTMwIiwKIngtaGN4LXN0YXR1cyI6InJlcXVlc3QucXVldWVkIiwKIngtaGN4LXdvcmtmbG93X2lkIjoiMjZiMTA2MGMtMWU4My00NjAwLTk2MTItZWEzMWUwY2E1MDk0IiwKIngtaGN4LWRlYnVnX2ZsYWciOiJJbmZvIiwKIngtaGN4LWRlYnVnX2RldGFpbHMiOnsiY29kZSI6IkVSUl9JTlZBTElEX0VOQ1JZUFRJT04iLCJtZXNzYWdlIjoiUmVjaXBpZW50IEludmFsaWQgRW5jcnlwdGlvbiIsInRyYWNlIjoiIn0KfQ==.6KB707dM9YTIgHtLvtgWQ8mKwboJW3of9locizkDTHzBC2IlrT1oOQ.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.KDlTtXchhZTGufMYmOYGS4HffxPSUrfmqCHXaI9wOGY.Mz-VPPyU4RlcuYv1IwIvzw");
    }

    protected Map<String,Object> getOnRequestBody(){
        return Collections.singletonMap("payload","eyJlbmMiOiJBMjU2R0NNIiwKImFsZyI6IlJTQS1PQUVQIiwKIngtaGN4LXNlbmRlcl9jb2RlIjoiMS0zYTNiZDY4YS04NDhhLTRkNTItOWVjMi0wN2E5MmQ3NjVmYjQiLAoieC1oY3gtcmVjaXBpZW50X2NvZGUiOiIxLWNlMjNjY2RjLWU2NDUtNGUzNS05N2I4LTBiZDhmZWY0M2VjZCIsCiJ4LWhjeC1hcGlfY2FsbF9pZCI6IjI2YjEwNjBjLTFlODMtNDYwMC05NjEyLWVhMzFlMGNhNTA5MyIsCiJ4LWhjeC1jb3JyZWxhdGlvbl9pZCI6IjVlOTM0ZjkwLTExMWQtNGYwYi1iMDE2LWMyMmQ4MjA2NzRlMSIsCiJ4LWhjeC10aW1lc3RhbXAiOiIyMDIxLTEwLTI3VDIwOjM1OjUyLjYzNiswNTMwIiwKIngtaGN4LXN0YXR1cyI6InJlc3BvbnNlLnBhcnRpYWwiLAoieC1oY3gtd29ya2Zsb3dfaWQiOiIyNmIxMDYwYy0xZTgzLTQ2MDAtOTYxMi1lYTMxZTBjYTUwOTQiLAoieC1oY3gtZGVidWdfZmxhZyI6IkluZm8iLAoieC1oY3gtZGVidWdfZGV0YWlscyI6eyJjb2RlIjoiRVJSX0lOVkFMSURfRU5DUllQVElPTiIsIm1lc3NhZ2UiOiJSZWNpcGllbnQgSW52YWxpZCBFbmNyeXB0aW9uIiwidHJhY2UiOiIifQp9.6KB707dM9YTIgHtLvtgWQ8mKwboJW3of9locizkDTHzBC2IlrT1oOQ.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.KDlTtXchhZTGufMYmOYGS4HffxPSUrfmqCHXaI9wOGY.Mz-VPPyU4RlcuYv1IwIvzw");
    }

    @Test
    void testActionJWEPayloadSuccess() throws Exception {
        boolean isValid = ValidateHelper.getInstance().validateRequest(JSONUtils.serialize(getRequestBody()), Operations.COVERAGE_ELIGIBILITY_CHECK,new HashMap<>());
        assertEquals(true, isValid);
    }


    @Test
    void testOnActionJWEPayloadSuccess() throws Exception {
        boolean isValid = ValidateHelper.getInstance().validateRequest(JSONUtils.serialize(getOnRequestBody()), Operations.COVERAGE_ELIGIBILITY_ON_CHECK,new HashMap<>());
        assertEquals(true, isValid);
    }
   @Test
    void testActionJWEPayloadSuccessFail() {
        boolean isValid = ValidateHelper.getInstance().validateRequest(null,Operations.COVERAGE_ELIGIBILITY_ON_CHECK,new HashMap<>());
        assertEquals(false, isValid);
    }
}
