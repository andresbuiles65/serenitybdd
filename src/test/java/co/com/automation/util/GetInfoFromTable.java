package co.com.automation.util;

import co.com.automation.models.LoginModel;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GetInfoFromTable {

    public static LoginModel getLoginCredentials (DataTable userLogin){

        List<List<String>> rows = userLogin.asLists(String.class);
        String username = "";
        String password = "";

        for (List<String> columns: rows){
            username = columns.get(0);
            password = columns.get(1);
        }
        LoginModel loginModel = new LoginModel();

        loginModel.setUsername(username);
        loginModel.setPassword(password);
        return loginModel;

    }
}
