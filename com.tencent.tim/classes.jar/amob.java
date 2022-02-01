import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class amob
  extends amnr
{
  protected String cba;
  private String cbb;
  private String mSenderUin;
  private String mUin;
  private int mUinType;
  
  public amob(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, List<FTSMessage> paramList, String paramString3, CharSequence paramCharSequence)
  {
    super(paramQQAppInterface, paramString1, paramString2, paramArrayList, paramList);
    paramString1 = (FTSMessage)paramList.get(0);
    this.mUin = String.valueOf(paramString1.uin);
    this.mSenderUin = paramString1.senderuin;
    this.mUinType = paramString1.istroop;
    this.cba = paramString3;
    this.title = paramCharSequence;
    int i;
    if (this.mUinType == 3000)
    {
      i = ((acdu)paramQQAppInterface.getManager(53)).cn(this.mUin);
      if (i <= 0) {
        this.cbb = "";
      }
    }
    else
    {
      return;
    }
    this.cbb = String.valueOf(i);
  }
  
  public void cR(View paramView)
  {
    Object localObject1;
    Object localObject2;
    JSONObject localJSONObject;
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      if (amkl.mT.containsKey(this))
      {
        localObject1 = (amkl.a)amkl.mT.get(this);
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", ((amkl.a)localObject1).index);
      localJSONObject.put("get_src", "native");
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((amkl.a)localObject1).ajO + "").obj2(((amkl.a)localObject1).caE).ver1(((amkl.a)localObject1).key).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + amkl.ajN));
      amub.a(null, this.source, 0, "0X8009D4D", 0, 0, null, null);
      if (this.title != null) {
        this.title = aqoe.a(this.app, this.app.getApp(), this.mUin, this.mUinType, this.mSenderUin);
      }
      localObject1 = (Integer)paramView.getTag(2131381961);
      localObject2 = (Integer)paramView.getTag(2131381959);
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (((Integer)localObject1).intValue() >= 0) && (((Integer)localObject2).intValue() >= 0))
      {
        amxk.b("all_result", "clk_talk", new String[] { "" + this.keyword, "" + localObject2, "" + (((Integer)localObject1).intValue() + 1) });
        if (this.FR.size() != 1) {
          break label699;
        }
        aqoe.a.itemType = 1;
        aqoe.a.eaB = this.searchStrategy;
        aqoe.a.eaC = this.mUinType;
        aqoe.a.senderNum = this.senderNum;
        aqoe.a.friendNum = this.friendNum;
        aqoe.a.friendIndex = this.friendIndex;
        aqoe.iv(paramView);
        if (this.FR.size() != 1) {
          break label725;
        }
        aalb.bwg = true;
        localObject1 = (FTSMessage)this.FR.get(0);
        if (((FTSMessage)localObject1).msgExts != null)
        {
          if ((((FTSMessage)localObject1).istroop != 1) && (((FTSMessage)localObject1).istroop != 3000)) {
            break label706;
          }
          aalb.LY = ((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject1).msgExts).shmsgseq;
        }
        aclj.Q(this.app, this.keyword);
        aalb.a(paramView.getContext(), this.app, this.mUin, this.mUinType, (String)this.title, false);
        amxk.a(this.keyword, 40, paramView, false);
        amxk.a(this.keyword, 40, 0, paramView);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("FTSMessageSearchResultModel", 2, "e = " + localJSONException);
        continue;
        if ((paramView.getContext() instanceof FTSEntitySearchDetailActivity))
        {
          amxk.b("talk", "clk_talk", new String[] { "" + this.keyword, "" + localObject2, "" + (((Integer)localObject1).intValue() + 1) });
          continue;
          label699:
          aqoe.a.itemType = 2;
          continue;
          label706:
          aalb.LY = ((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject1).msgExts).time;
          continue;
          label725:
          FTSEntitySearchDetailActivity.a(paramView.getContext(), getKeyword(), this.caY, this.title, this.FR, 1, this.mUin, this.mUinType);
        }
      }
    }
  }
  
  public CharSequence f()
  {
    if ((this.mUinType == 3000) && (!TextUtils.isEmpty(this.cbb))) {
      return amxk.d(this.cbb);
    }
    return "";
  }
  
  public CharSequence getDescription()
  {
    int i;
    if (this.description == null)
    {
      i = this.FR.size();
      if (i == 1) {
        this.description = amxk.a(((FTSEntity)this.FR.get(0)).mContent, ((FTSEntity)this.FR.get(0)).mProximityStart, this.zy);
      }
    }
    else
    {
      return this.description;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(i + acfp.m(2131706659) + "\"");
    if ((this.cba != null) && ((this.zy == null) || (this.zy.isEmpty()))) {
      localSpannableStringBuilder.append(amxk.a(this.cba, this.cba));
    }
    for (;;)
    {
      localSpannableStringBuilder.append("\"").append("相关记录");
      this.description = localSpannableStringBuilder;
      break;
      localSpannableStringBuilder.append(amxk.a(this.keyword, this.keyword));
    }
  }
  
  public CharSequence getTitle()
  {
    if (this.title == null) {
      this.title = aqgv.d(this.app, this.mUin, this.mUinType);
    }
    return this.title;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public int pG()
  {
    switch (this.mUinType)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("FTSMessageSearchResultModel", 2, "Face type is illegal. type = " + this.mUinType);
      }
    case 0: 
      return 1;
    case 1: 
      return 4;
    }
    return 101;
  }
  
  public CharSequence v()
  {
    if ((this.FR != null) && (this.FR.size() == 1) && (this.ag == null) && ((this.FR.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.FR.get(0)).matchTitle;
      if (localCharSequence != null) {
        this.ag = localCharSequence;
      }
    }
    return this.ag;
  }
  
  public CharSequence w()
  {
    if ((this.FR != null) && (this.FR.size() == 1) && (this.ah == null) && ((this.FR.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.FR.get(0)).matchSecondTitle;
      if (localCharSequence != null) {
        this.ah = localCharSequence;
      }
    }
    return this.ah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amob
 * JD-Core Version:    0.7.0.1
 */