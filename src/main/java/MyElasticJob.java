import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {

        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(format + " context = " + ToStringBuilder.reflectionToString(context, ToStringStyle.JSON_STYLE));

        System.out.println(String.format(format + "------Thread ID: %s, 任务总片数: %s, 当前分片项: %s",
                Thread.currentThread().getId(), context.getShardingTotalCount(), context.getShardingItem()));

        switch (context.getShardingItem()) {


            case 0:
                // do something by sharding item 0
                break;
            case 1:
                // do something by sharding item 1
                break;
            case 2:
                // do something by sharding item 2
                break;
            // case n: ...
        }
    }

}