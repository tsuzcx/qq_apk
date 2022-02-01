import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import java.util.ArrayList;

public class amoa
  extends amnq
{
  private String senderUin;
  private String uin;
  private int uinType;
  
  public amoa(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    super(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
    paramQQAppInterface = (FTSMessage)this.a;
    this.uin = String.valueOf(paramQQAppInterface.uin);
    this.senderUin = paramQQAppInterface.senderuin;
    this.uinType = paramQQAppInterface.istroop;
    getTitle();
  }
  
  public void cR(View paramView)
  {
    aalb.bwg = true;
    FTSMessage localFTSMessage = (FTSMessage)this.a;
    if (localFTSMessage.msgExts != null) {
      if ((localFTSMessage.istroop != 1) && (localFTSMessage.istroop != 3000)) {
        break label173;
      }
    }
    label173:
    for (aalb.LY = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).shmsgseq;; aalb.LY = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time)
    {
      aqoe.a.eaB = localFTSMessage.searchStrategy;
      aqoe.a.itemType = 1;
      aqoe.a.eaC = this.uinType;
      aqoe.a.senderNum = ((FTSMessage)this.a).senderNum;
      aqoe.a.friendNum = ((FTSMessage)this.a).friendNum;
      aqoe.a.friendIndex = ((FTSMessage)this.a).friendIndex;
      aqoe.iv(paramView);
      aalb.a(paramView.getContext(), this.app, this.uin, this.uinType, aqgv.d(this.app, this.uin, this.uinType), false);
      aclj.Q(this.app, this.keyword);
      amxk.a(this.keyword, 40, paramView, true);
      return;
    }
  }
  
  public CharSequence getDescription()
  {
    if (TextUtils.isEmpty(this.ae))
    {
      this.ae = "";
      FTSMessage localFTSMessage = (FTSMessage)this.a;
      if (localFTSMessage.msgExts != null) {
        this.ae = aqmu.a(BaseApplicationImpl.sApplication, 3, ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time * 1000L);
      }
    }
    return this.ae;
  }
  
  public CharSequence getTitle()
  {
    FTSMessage localFTSMessage;
    if (this.title == null)
    {
      localFTSMessage = (FTSMessage)this.a;
      if (localFTSMessage.matchTitle == null) {
        break label35;
      }
      this.title = localFTSMessage.matchTitle;
    }
    for (;;)
    {
      return this.title;
      label35:
      boolean bool = this.app.getCurrentAccountUin().equals(localFTSMessage.senderuin);
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.cZ = this.uinType;
      localSessionInfo.aTl = this.uin;
      if ("80000000".equals(this.uin)) {
        this.title = acfp.m(2131706658);
      } else {
        this.title = aqgv.a(this.app, localSessionInfo, bool, localFTSMessage.senderuin);
      }
    }
  }
  
  public String getUin()
  {
    return String.valueOf(((FTSMessage)this.a).senderuin);
  }
  
  public CharSequence u()
  {
    if (this.af == null)
    {
      FTSMessage localFTSMessage = (FTSMessage)this.a;
      if (localFTSMessage.matchSecondTitle != null) {
        this.af = localFTSMessage.matchSecondTitle;
      }
    }
    return this.af;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amoa
 * JD-Core Version:    0.7.0.1
 */