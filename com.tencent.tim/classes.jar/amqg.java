import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqg
  extends ampy
{
  public static final String TAG = "Q.uniteSearch." + amqg.class.getName();
  public List<String> FZ;
  private List<Object> Gc;
  public amqg.a a;
  public amxa a;
  public long ajO;
  public boolean cDK;
  private String cbA;
  public String cbB;
  public String extension;
  public int from;
  public String id;
  public String imageUrl;
  private Object item;
  public String jumpUrl;
  public String keyword;
  private int mLayoutId;
  
  public amqg(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.id = paramResultItem.result_id.get().toStringUtf8();
      this.mLayoutId = paramResultItem.layout_id.get();
      this.extension = paramResultItem.extension.get().toStringUtf8();
      this.cbA = paramResultItem.layout_content.get().toStringUtf8();
      this.jumpUrl = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.ajO = paramLong;
      if (paramResultItem.sub_result_items.has())
      {
        this.Gc = new ArrayList();
        this.Gc.addAll(paramResultItem.sub_result_items.get());
      }
      this.cbB = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.from = paramInt;
    this.item = paramResultItem;
    this.FZ = paramList;
    this.keyword = paramString;
    this.jdField_a_of_type_Amxa = new amxa(paramList, getKeyword());
    if (!TextUtils.isEmpty(this.cbA)) {
      PS(this.cbA);
    }
  }
  
  public amqg(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.id = paramResultItem.result_id.get().toStringUtf8();
      this.mLayoutId = paramResultItem.layout_id.get();
      this.extension = paramResultItem.extension.get().toStringUtf8();
      this.cbA = paramResultItem.layout_content.get().toStringUtf8();
      this.jumpUrl = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.ajO = paramLong;
      if (paramResultItem.sub_result_items.has())
      {
        this.Gc = new ArrayList();
        this.Gc.addAll(paramResultItem.sub_result_items.get());
      }
      this.cbB = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.from = paramInt;
    this.item = paramResultItem;
    this.FZ = paramList;
    this.keyword = paramString;
    this.jdField_a_of_type_Amxa = new amxa(paramList, getKeyword());
    if (!TextUtils.isEmpty(this.cbA)) {
      PS(this.cbA);
    }
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IX()
  {
    return this.mLayoutId;
  }
  
  public void PS(String paramString) {}
  
  public Object T()
  {
    return this.item;
  }
  
  public void bw(JSONObject paramJSONObject)
  {
    boolean bool = true;
    this.jdField_a_of_type_Amqg$a = new amqg.a();
    int i = paramJSONObject.optInt("imageType");
    this.jdField_a_of_type_Amqg$a.imageUrl = paramJSONObject.optString("imageUrl");
    this.jdField_a_of_type_Amqg$a.imageType = jg(i);
    this.jdField_a_of_type_Amqg$a.cornerRadius = paramJSONObject.optInt("cornerRadius");
    amqg.a locala = this.jdField_a_of_type_Amqg$a;
    if (paramJSONObject.optInt("needPlayIcon") == 1) {}
    for (;;)
    {
      locala.cDU = bool;
      this.jdField_a_of_type_Amqg$a.ap = paramJSONObject.optString("topLeftTagText");
      this.jdField_a_of_type_Amqg$a.cbC = paramJSONObject.optString("topLeftTagColor");
      this.jdField_a_of_type_Amqg$a.aq = paramJSONObject.optString("bottomRightText");
      this.jdField_a_of_type_Amqg$a.cbD = paramJSONObject.optString("bottomRightIconUrl");
      this.jdField_a_of_type_Amqg$a.ar = paramJSONObject.optString("bottomRightIconText");
      this.jdField_a_of_type_Amqg$a.imageHeight = paramJSONObject.optInt("imageHeight");
      this.jdField_a_of_type_Amqg$a.imageWidth = paramJSONObject.optInt("imageWidth");
      return;
      bool = false;
    }
  }
  
  public void cR(View paramView)
  {
    Object localObject3 = this.jumpUrl;
    amkl.a locala;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (amkl.mT.containsKey(this))
    {
      locala = (amkl.a)amkl.mT.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", locala.index);
      localJSONObject.put("get_src", "web");
      localJSONObject.put("tepl", this.cbB);
      Object localObject1 = "clk_item";
      if ((this instanceof amqt)) {
        localObject1 = "clk_more";
      }
      amub.a(null, new ReportModelDC02528().module("all_result").action((String)localObject1).obj1(this.ajO + "").obj2(locala.caE).ver1(this.keyword).ver2(amub.eZ(this.from)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
      if (amkl.mS.containsKey(this))
      {
        localObject1 = (amkl.a)amkl.mS.get(this);
        if (((amkl.a)localObject1).cDd)
        {
          i = 2;
          amxk.e("all_result", "clk_object", i, 0, new String[] { this.keyword, "" + this.ajO, ((amkl.a)localObject1).caE + "", ((amkl.a)localObject1).index + "" });
        }
      }
      else
      {
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label572;
        }
        localObject1 = aqik.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), (String)localObject3);
        if (localObject1 == null) {
          break label448;
        }
        ((aqhv)localObject1).ace();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      label448:
      do
      {
        for (;;)
        {
          QLog.e(TAG, 2, "e = " + localJSONException);
          continue;
          int i = 1;
        }
        Object localObject2;
        if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
        {
          avpw.aae((String)localObject3);
          paramView = paramView.getContext();
          localObject2 = new Intent(paramView, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject3);
          paramView.startActivity((Intent)localObject2);
          return;
        }
        if (((String)localObject3).startsWith("tel://"))
        {
          localObject2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((String)localObject3).substring(6)));
          paramView.getContext().startActivity((Intent)localObject2);
        }
        if (this.ajO == 268435456L)
        {
          amxk.x(paramView.getContext(), Integer.valueOf(this.id).intValue(), -1);
          return;
        }
        if (this.ajO == 1001L)
        {
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject3 = new SearchResultItem();
          ((SearchResultItem)localObject3).lUIN = Long.valueOf(this.id).longValue();
          ((SearchResultItem)localObject3).strNick = getTitle().toString();
          AddFriendActivity.a((Activity)paramView.getContext(), (SearchResultItem)localObject3, (QQAppInterface)localObject2, true, 1);
          return;
        }
        if (this.ajO == 536870912L)
        {
          long l2 = 0L;
          try
          {
            l1 = Long.valueOf(new JSONObject(this.extension).optString("proid")).longValue();
            ppf.b(paramView.getContext(), 24, l1);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.e(TAG, 2, localException, new Object[0]);
                l1 = l2;
              }
            }
          }
        }
      } while (this.ajO != 1002L);
      label572:
      Bundle localBundle = TroopInfoActivity.c(this.id, 2);
      localBundle.putInt("exposureSource", 3);
      localBundle.putInt("t_s_f", 1000);
      apuh.a(paramView.getContext(), localBundle, 2);
    }
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    return null;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public int getLayoutId()
  {
    switch (this.mLayoutId)
    {
    case 5: 
    case 10: 
    default: 
      throw new RuntimeException(this.mLayoutId + "in NetSearchTemplateBaseItem.getLayoutId() is not supported!!!");
    case 2: 
      return 2131560018;
    case 3: 
      return 2131560034;
    case 4: 
      return 2131560019;
    case 6: 
      return 2131560033;
    case 7: 
      return 2131560022;
    case 8: 
      return 2131560030;
    case 9: 
      return 2131560031;
    case 11: 
      return 2131560021;
    case 12: 
      return 2131560020;
    case 13: 
      return 2131560024;
    case 14: 
      return 2131560032;
    case 15: 
      return 2131560028;
    case 16: 
      return 2131560009;
    case 17: 
      return 2131561653;
    }
    return 2131563028;
  }
  
  public CharSequence getTitle()
  {
    return null;
  }
  
  public String getUin()
  {
    return this.id;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public int jg(int paramInt)
  {
    return 1;
  }
  
  public int pG()
  {
    return 1;
  }
  
  public class a
  {
    public CharSequence ap;
    public CharSequence aq;
    public CharSequence ar;
    public boolean cDU;
    public String cbC;
    public String cbD;
    public int cornerRadius;
    public int imageHeight;
    public int imageType;
    public String imageUrl;
    public int imageWidth;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqg
 * JD-Core Version:    0.7.0.1
 */