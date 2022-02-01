import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class kqp
  extends lce
{
  kqp(kqo paramkqo) {}
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (kqo.a(this.this$0) == paramInt))
    {
      kqo.a(this.this$0, (ArrayList)paramList);
      if ((kqo.a(this.this$0) == null) || (kqo.a(this.this$0) == null) || (kqo.a(this.this$0).size() <= 0)) {
        break label200;
      }
      kqo.a(this.this$0).setData(kqo.a(this.this$0));
      kqo.a(this.this$0).notifyDataSetChanged();
      if (kqo.a(this.this$0).findHeaderViewPosition(kqo.a(this.this$0)) < 0) {
        kqo.a(this.this$0).addHeaderView(kqo.a(this.this$0));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onSubChannelListUpdate infos size" + kqo.a(this.this$0).size());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onSubChannelListUpdate" + paramBoolean);
      }
      return;
      label200:
      kqo.a(this.this$0).removeHeaderView(kqo.a(this.this$0));
    }
  }
  
  public void e(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (kqo.a(this.this$0) == 0))
    {
      kqo.a(this.this$0, (ArrayList)paramList);
      if ((kqo.a(this.this$0) != null) && (kqo.a(this.this$0) != null) && (kqo.a(this.this$0).size() > 0))
      {
        kqo.a(this.this$0).setData(kqo.a(this.this$0));
        kqo.a(this.this$0).notifyDataSetChanged();
        if (kqo.a(this.this$0).findHeaderViewPosition(kqo.a(this.this$0)) < 0) {
          kqo.a(this.this$0).addHeaderView(kqo.a(this.this$0));
        }
        paramList = paramList.iterator();
      }
      label134:
      while (paramList.hasNext())
      {
        Object localObject = (ChannelCoverInfo)paramList.next();
        if ((!TextUtils.isEmpty(((ChannelCoverInfo)localObject).mChannelJumpUrl)) && (((ChannelCoverInfo)localObject).mChannelJumpUrl.indexOf("html/topic.html") != -1)) {
          for (;;)
          {
            int i;
            try
            {
              for (;;)
              {
                localObject = new URL(((ChannelCoverInfo)localObject).mChannelJumpUrl);
                if (TextUtils.isEmpty(((URL)localObject).getQuery())) {
                  break;
                }
                localObject = ((URL)localObject).getQuery().split("[&]");
                int j = localObject.length;
                i = 0;
                if (i >= j) {
                  break;
                }
                String[] arrayOfString = localObject[i].split("[=]");
                if (arrayOfString.length <= 1) {
                  break label388;
                }
                boolean bool = "topicid".equals(arrayOfString[0]);
                if (!bool) {
                  break label388;
                }
                try
                {
                  Integer.valueOf(arrayOfString[1]).intValue();
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate preload topic and topicId = " + arrayOfString[1]);
                }
                catch (Exception localException) {}
              }
              if (!QLog.isColorLevel()) {
                break label134;
              }
              QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate preload topic and topic is illegal");
            }
            catch (MalformedURLException localMalformedURLException) {}
            if (!QLog.isColorLevel()) {
              break label134;
            }
            QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate preload topic MalformedURLException " + localMalformedURLException);
            break label134;
            kqo.a(this.this$0).removeHeaderView(kqo.a(this.this$0));
            break;
            i += 1;
          }
        }
      }
      label388:
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate infos size" + kqo.a(this.this$0).size());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate" + paramBoolean);
    }
  }
  
  public void g(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (kqo.a(this.this$0) == 56))
    {
      kqo.a(this.this$0, (ArrayList)paramList);
      if ((kqo.a(this.this$0) == null) || (kqo.a(this.this$0) == null) || (kqo.a(this.this$0).size() <= 0)) {
        break label201;
      }
      kqo.a(this.this$0).setData(kqo.a(this.this$0));
      kqo.a(this.this$0).notifyDataSetChanged();
      if (kqo.a(this.this$0).findHeaderViewPosition(kqo.a(this.this$0)) < 0) {
        kqo.a(this.this$0).addHeaderView(kqo.a(this.this$0));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onVideoChannelListUpdate infos size" + kqo.a(this.this$0).size());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onVideoChannelListUpdate" + paramBoolean);
      }
      return;
      label201:
      kqo.a(this.this$0).removeHeaderView(kqo.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqp
 * JD-Core Version:    0.7.0.1
 */