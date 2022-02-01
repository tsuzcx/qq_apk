import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class amlv<M extends ampu, V extends amxw>
  extends amlu<M, V>
{
  private QQAppInterface app;
  private FullMessageSearchResult.SearchResultItem b;
  private int dCM;
  private int dCN;
  private int dCO;
  private List<amqa> jl;
  private String keyword;
  private String peerUin;
  private int type;
  
  public amlv(ListView paramListView, aqdf paramaqdf, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramaqdf);
    try
    {
      this.b = paramSearchResultItem;
      this.peerUin = paramSearchResultItem.user.uin;
      this.type = paramSearchResultItem.user.getType();
      this.keyword = paramString;
      this.app = paramQQAppInterface;
      this.jl = new ArrayList();
      return;
    }
    catch (NullPointerException paramListView)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, new Object[] { "BaseMvpMessageAdapter init e:", paramListView.toString() });
      }
    }
  }
  
  private void akx()
  {
    if ((this.dCO - this.dCN == this.dCM) && (this.mScrollState == 0)) {
      initData();
    }
  }
  
  private void av(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2011)
    {
      AbsStructMsg localAbsStructMsg = anre.a(paramMessageRecord.msgData);
      if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg)))
      {
        paramMessageRecord.msg = ((AbsShareMsg)localAbsStructMsg).mContentTitle;
        if ((TextUtils.isEmpty(paramMessageRecord.msg)) && ((localAbsStructMsg instanceof AbsStructMsg))) {
          paramMessageRecord.msg = ((AbsShareMsg)localAbsStructMsg).mMsgBrief;
        }
      }
    }
  }
  
  public void initData()
  {
    label177:
    for (;;)
    {
      try
      {
        int j = this.jl.size();
        int i;
        if (j + 50 < this.b.secondPageMessageUniseq.size())
        {
          i = j + 50;
          if (j < i)
          {
            MessageRecord localMessageRecord = this.app.b().b(this.peerUin, this.type, ((Long)this.b.secondPageMessageUniseq.get(j)).longValue());
            if (localMessageRecord == null) {
              break label177;
            }
            av(localMessageRecord);
            if (localMessageRecord.msg == null) {
              break label177;
            }
            this.jl.add(new amqa(this.app, this.keyword, this.b.user, localMessageRecord));
            break label177;
          }
        }
        else
        {
          i = this.b.secondPageMessageUniseq.size();
          continue;
        }
        j += 1;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, new Object[] { "initData e:", localNullPointerException.toString() });
        super.cS(this.jl);
        return;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.dCN = paramInt1;
    this.dCM = paramInt2;
    this.dCO = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    akx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlv
 * JD-Core Version:    0.7.0.1
 */