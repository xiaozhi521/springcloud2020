import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author mu_qingfeng
 * @date 2020/7/16 8:15 PM
 */
public class T2 {

    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now();

        System.out.println(time);
        //2020-07-16T20:17:59.389+08:00[Asia/Shanghai]

        ZonedDateTime time2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(time2);
        //2020-07-16T08:17:59.394-04:00[America/New_York]
    }
}
