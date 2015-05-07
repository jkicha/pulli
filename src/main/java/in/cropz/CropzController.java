package in.cropz;

import in.cropz.domain.Dealer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Controller
public class CropzController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/dealers")
    public String dealer(Model model) {
        String sql = "select achead, acname, address3 from subledger";

        List<Map<String, Object>> dealerList  = jdbcTemplate.queryForList(sql);


//        for (Dealer d:dealerList){
//            System.out.println("Dealer info is " + d.getDealerId() + " -- " + d.getDealerName() + " -- " + d.getDealerCity() + "/n");
//        }

        List<Dealer> dealers = new ArrayList<Dealer>();
        for (Map<String, Object> d : dealerList) {
            Dealer dealer = new Dealer();
            dealer.setDealerId((Long)(d.get("ACHEAD")));
            dealer.setDealerName((String)d.get("ACNAME"));
            dealer.setDealerCity((String)d.get("ADDRESS3"));
            dealers.add(dealer);
        }

        model.addAttribute("dealerList", dealers);
        return "dealers";
    }

    @RequestMapping("/")
    public String index() {
        int rowCount = jdbcTemplate.queryForInt("select count(*) from subledger");
        return "Rows in subledger is " +  rowCount;
    }

}