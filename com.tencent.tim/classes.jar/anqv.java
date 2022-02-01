import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public abstract class anqv
  extends anqu
{
  public int bvK;
  public int dMi;
  protected int dMj;
  protected int dMk;
  public ArrayList<anqu> rz;
  
  protected anqv()
  {
    this.mTypeName = "item";
    this.rz = new ArrayList();
    this.bvK = IX();
  }
  
  protected anqv(Collection<anqu> paramCollection)
  {
    this.mTypeName = "item";
    this.rz = new ArrayList(paramCollection);
    this.bvK = IX();
  }
  
  private boolean ayV()
  {
    return (this.dMj >= 0) && (this.dMj <= 3);
  }
  
  protected abstract int IX();
  
  public void Rn(String paramString)
  {
    a(new anux(paramString));
    a(new anst());
  }
  
  public void Ro(String paramString)
  {
    this.bvK = 0;
    a(new ansu(paramString));
  }
  
  public void Vs(int paramInt)
  {
    this.dMi = paramInt;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return b(paramContext, paramView, paramBundle);
  }
  
  public void a(anqu paramanqu)
  {
    if (((paramanqu instanceof anqw)) && (!ayV())) {
      ((anqw)paramanqu).textColor = null;
    }
    this.rz.add(paramanqu);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, this.mTypeName);
    if (this.bvK < 0) {}
    for (Object localObject = "0";; localObject = String.valueOf(this.bvK))
    {
      paramXmlSerializer.attribute(null, "layout", (String)localObject);
      if (!TextUtils.isEmpty(this.cgX)) {
        paramXmlSerializer.attribute(null, "action", this.cgX);
      }
      if (!TextUtils.isEmpty(this.cgY)) {
        paramXmlSerializer.attribute(null, "actionData", this.cgY);
      }
      if (!TextUtils.isEmpty(this.cgZ)) {
        paramXmlSerializer.attribute(null, "a_actionData", this.cgZ);
      }
      if (!TextUtils.isEmpty(this.cha)) {
        paramXmlSerializer.attribute(null, "i_actionData", this.cha);
      }
      if (!TextUtils.isEmpty(this.ku)) {
        paramXmlSerializer.attribute(null, "url", this.ku);
      }
      if (!TextUtils.isEmpty(this.chb)) {
        paramXmlSerializer.attribute(null, "brief", this.chb);
      }
      if (this.dMh != 0) {
        paramXmlSerializer.attribute(null, "flag", String.valueOf(this.dMh));
      }
      if (this.dMi != 0) {
        paramXmlSerializer.attribute(null, "mode", String.valueOf(this.dMi));
      }
      if (this.dMj != 0) {
        paramXmlSerializer.attribute(null, "bg", String.valueOf(this.dMj));
      }
      if (!TextUtils.isEmpty(this.chc)) {
        paramXmlSerializer.attribute(null, "businessData", this.chc);
      }
      if (!TextUtils.isEmpty(this.mCommonData)) {
        paramXmlSerializer.attribute(null, "commonData", this.mCommonData);
      }
      if (!TextUtils.isEmpty(this.index)) {
        paramXmlSerializer.attribute(null, "index", this.index);
      }
      if (!TextUtils.isEmpty(this.index_name)) {
        paramXmlSerializer.attribute(null, "index_name", this.index_name);
      }
      if (!TextUtils.isEmpty(this.index_type)) {
        paramXmlSerializer.attribute(null, "index_type", this.index_type);
      }
      if (!TextUtils.isEmpty(this.chf)) {
        paramXmlSerializer.attribute(null, "canvas", this.chf);
      }
      if (!TextUtils.isEmpty(this.chd)) {
        paramXmlSerializer.attribute(null, "rurl", this.chd);
      }
      if (!TextUtils.isEmpty(this.chg)) {
        paramXmlSerializer.attribute(null, "disType", this.chg);
      }
      if (!TextUtils.isEmpty(this.che)) {
        paramXmlSerializer.attribute(null, "tid", this.che);
      }
      if (!TextUtils.isEmpty(this.chh)) {
        paramXmlSerializer.attribute(null, "apurl", this.chh);
      }
      if (this.dLY != 0) {
        paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.dLY));
      }
      if (!TextUtils.isEmpty(this.chi)) {
        paramXmlSerializer.attribute(null, "advertiser_id", this.chi);
      }
      if (!TextUtils.isEmpty(this.chj)) {
        paramXmlSerializer.attribute(null, "aid", this.chj);
      }
      if (!TextUtils.isEmpty(this.chk)) {
        paramXmlSerializer.attribute(null, "app_download_schema", this.chk);
      }
      if (!TextUtils.isEmpty(this.chl)) {
        paramXmlSerializer.attribute(null, "canvas_json", this.chl);
      }
      if (!TextUtils.isEmpty(this.chm)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.chm);
      }
      if (this.dLZ != 0) {
        paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.dLZ));
      }
      if (!TextUtils.isEmpty(this.chn)) {
        paramXmlSerializer.attribute(null, "effect_url", this.chn);
      }
      if (!TextUtils.isEmpty(this.cho)) {
        paramXmlSerializer.attribute(null, "landing_page", this.cho);
      }
      if (!TextUtils.isEmpty(this.chp)) {
        paramXmlSerializer.attribute(null, "landing_page_report_url", this.chp);
      }
      if (!TextUtils.isEmpty(this.chq)) {
        paramXmlSerializer.attribute(null, "noco_id", this.chq);
      }
      if (!TextUtils.isEmpty(this.chr)) {
        paramXmlSerializer.attribute(null, "product_id", this.chr);
      }
      if (this.dMa != 0) {
        paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.dMa));
      }
      if (this.dMb != 0) {
        paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.dMb));
      }
      if (!TextUtils.isEmpty(this.chs)) {
        paramXmlSerializer.attribute(null, "rl", this.chs);
      }
      if (!TextUtils.isEmpty(this.cht)) {
        paramXmlSerializer.attribute(null, "subordinate_product_id", this.cht);
      }
      if (!TextUtils.isEmpty(this.chu)) {
        paramXmlSerializer.attribute(null, "traceid", this.chu);
      }
      if (!TextUtils.isEmpty(this.chv)) {
        paramXmlSerializer.attribute(null, "via", this.chv);
      }
      if (!TextUtils.isEmpty(this.chw)) {
        paramXmlSerializer.attribute(null, "video_url", this.chw);
      }
      if (!TextUtils.isEmpty(this.mAppName)) {
        paramXmlSerializer.attribute(null, "appname", this.mAppName);
      }
      if (!TextUtils.isEmpty(this.chx)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.chx);
      }
      if (!TextUtils.isEmpty(this.mPkgName)) {
        paramXmlSerializer.attribute(null, "pkg_name", this.mPkgName);
      }
      if (!TextUtils.isEmpty(this.chy)) {
        paramXmlSerializer.attribute(null, "pkgurl", this.chy);
      }
      if (!TextUtils.isEmpty(this.bWQ)) {
        paramXmlSerializer.attribute(null, "api_exposure_monitor_url", this.bWQ);
      }
      if (!TextUtils.isEmpty(this.chz)) {
        paramXmlSerializer.attribute(null, "api_click_monitor_url", this.chz);
      }
      if (!TextUtils.isEmpty(this.chA)) {
        paramXmlSerializer.attribute(null, "trace_info_aid", this.chA);
      }
      if (!TextUtils.isEmpty(this.Wm)) {
        paramXmlSerializer.attribute(null, "corporate_image_name", this.Wm);
      }
      if (!TextUtils.isEmpty(this.Wn)) {
        paramXmlSerializer.attribute(null, "corporate_logo", this.Wn);
      }
      if (this.cdl != 0) {
        paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.cdl));
      }
      if (this.dMc != 0) {
        paramXmlSerializer.attribute(null, "is_hidden", String.valueOf(this.dMc));
      }
      if (!TextUtils.isEmpty(this.chB)) {
        paramXmlSerializer.attribute(null, "negative_feedback_url", this.chB);
      }
      if (!TextUtils.isEmpty(this.chC)) {
        paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.chC);
      }
      if (!TextUtils.isEmpty(this.chD)) {
        paramXmlSerializer.attribute(null, "sdk_click_monitor_url", this.chD);
      }
      if (this.dMd != 0) {
        paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.dMd));
      }
      if (this.dMe != 0) {
        paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.dMe));
      }
      if (this.dMf != 0) {
        paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.dMf));
      }
      if (this.dMg != 0) {
        paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.dMg));
      }
      if (!TextUtils.isEmpty(this.chE)) {
        paramXmlSerializer.attribute(null, "universal_link", this.chE);
      }
      if (!TextUtils.isEmpty(this.chF)) {
        paramXmlSerializer.attribute(null, "ext_json", this.chF);
      }
      if (!TextUtils.isEmpty(this.chG)) {
        paramXmlSerializer.attribute(null, "tencent_video_id", this.chG);
      }
      if (!TextUtils.isEmpty(this.Wj)) {
        paramXmlSerializer.attribute(null, "view_id", this.Wj);
      }
      localObject = this.rz.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((anqu)((Iterator)localObject).next()).a(paramXmlSerializer);
      }
    }
    paramXmlSerializer.endTag(null, this.mTypeName);
  }
  
  public boolean a(ansf paramansf)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramansf == null) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      this.cgX = paramansf.getAttribute("action");
      this.cgY = paramansf.getAttribute("actionData");
      this.cgZ = paramansf.getAttribute("a_actionData");
      this.cha = paramansf.getAttribute("i_actionData");
      this.ku = paramansf.getAttribute("url");
      this.chb = paramansf.getAttribute("brief");
      this.chh = paramansf.getAttribute("apurl");
      Object localObject1 = paramansf.getAttribute("flag");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        this.dMh = Integer.parseInt((String)localObject1);
        localObject1 = paramansf.getAttribute("mode");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      catch (NumberFormatException localNumberFormatException11)
      {
        try
        {
          this.dMi = Integer.parseInt((String)localObject1);
          localObject1 = paramansf.getAttribute("bg");
        }
        catch (NumberFormatException localNumberFormatException11)
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (((String)localObject1).startsWith("#")) {
                this.dMj = Color.parseColor((String)localObject1);
              }
            }
            else
            {
              this.chc = paramansf.getAttribute("businessData");
              this.mCommonData = paramansf.getAttribute("commonData");
              this.index = paramansf.getAttribute("index");
              this.index_name = paramansf.getAttribute("index_name");
              this.index_type = paramansf.getAttribute("index_type");
              this.chf = paramansf.getAttribute("canvas");
              this.chd = paramansf.getAttribute("rurl");
              this.chg = paramansf.getAttribute("disType");
              this.che = paramansf.getAttribute("tid");
              if (this.mVersion > 10)
              {
                localObject1 = paramansf.a;
                if (localObject1 != null)
                {
                  localObject3 = ((ansf)localObject1).getAttribute("action_type");
                  if (TextUtils.isEmpty((CharSequence)localObject3)) {}
                }
              }
            }
          }
          catch (IllegalArgumentException localNumberFormatException11)
          {
            try
            {
              this.dLY = Integer.parseInt((String)localObject3);
              localObject3 = ((ansf)localObject1).getAttribute("dest_type");
              if (TextUtils.isEmpty((CharSequence)localObject3)) {}
            }
            catch (NumberFormatException localNumberFormatException11)
            {
              try
              {
                this.dLZ = Integer.parseInt((String)localObject3);
                localObject3 = ((ansf)localObject1).getAttribute("product_type");
                if (TextUtils.isEmpty((CharSequence)localObject3)) {}
              }
              catch (NumberFormatException localNumberFormatException11)
              {
                try
                {
                  this.dMa = Integer.parseInt((String)localObject3);
                  this.chi = ((ansf)localObject1).getAttribute("advertiser_id");
                  this.chj = ((ansf)localObject1).getAttribute("aid");
                  this.chk = ((ansf)localObject1).getAttribute("app_download_schema");
                  this.chl = ((ansf)localObject1).getAttribute("canvas_json");
                  this.chm = ((ansf)localObject1).getAttribute("customized_invoke_url");
                  this.chn = ((ansf)localObject1).getAttribute("effect_url");
                  this.cho = ((ansf)localObject1).getAttribute("landing_page");
                  this.chp = ((ansf)localObject1).getAttribute("landing_page_report_url");
                  this.chq = ((ansf)localObject1).getAttribute("noco_id");
                  this.chr = ((ansf)localObject1).getAttribute("product_id");
                  this.chs = ((ansf)localObject1).getAttribute("rl");
                  this.cht = ((ansf)localObject1).getAttribute("subordinate_product_id");
                  this.chu = ((ansf)localObject1).getAttribute("traceid");
                  this.chv = ((ansf)localObject1).getAttribute("via");
                  this.chw = ((ansf)localObject1).getAttribute("video_url");
                  this.mAppName = ((ansf)localObject1).getAttribute("appname");
                  this.chx = ((ansf)localObject1).getAttribute("customized_invoke_url");
                  this.mPkgName = ((ansf)localObject1).getAttribute("pkg_name");
                  this.chy = ((ansf)localObject1).getAttribute("pkgurl");
                  this.chh = ((ansf)localObject1).getAttribute("apurl");
                  if (this.mVersion > 11)
                  {
                    localObject1 = paramansf.a;
                    if (localObject1 != null)
                    {
                      this.chz = ((ansf)localObject1).getAttribute("api_click_monitor_url");
                      this.bWQ = ((ansf)localObject1).getAttribute("api_exposure_monitor_url");
                      this.chA = ((ansf)localObject1).getAttribute("trace_info_aid");
                    }
                  }
                  if (this.mVersion > 12)
                  {
                    localObject1 = paramansf.a;
                    if (localObject1 != null)
                    {
                      this.Wm = ((ansf)localObject1).getAttribute("corporate_image_name");
                      this.Wn = ((ansf)localObject1).getAttribute("corporate_logo");
                    }
                  }
                  if (this.mVersion > 13)
                  {
                    localObject1 = paramansf.a.getAttribute("mini_program_type");
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
                  }
                }
                catch (NumberFormatException localNumberFormatException11)
                {
                  try
                  {
                    this.dMb = Integer.parseInt((String)localObject1);
                    if (this.mVersion > 14)
                    {
                      localObject1 = paramansf.a;
                      if (localObject1 != null)
                      {
                        localObject3 = ((ansf)localObject1).getAttribute("tab_id");
                        if (aqmr.isEmpty((String)localObject3)) {}
                      }
                    }
                  }
                  catch (NumberFormatException localNumberFormatException11)
                  {
                    try
                    {
                      this.cdl = Integer.parseInt((String)localObject3);
                      localObject1 = ((ansf)localObject1).getAttribute("is_hidden");
                      if (aqmr.isEmpty((String)localObject1)) {}
                    }
                    catch (NumberFormatException localNumberFormatException11)
                    {
                      try
                      {
                        this.dMc = Integer.parseInt((String)localObject1);
                        if (this.mVersion > 15)
                        {
                          localObject1 = paramansf.a;
                          this.chB = ((ansf)localObject1).getAttribute("negative_feedback_url");
                          this.chC = ((ansf)localObject1).getAttribute("sdk_exposure_monitor_url");
                          this.chD = ((ansf)localObject1).getAttribute("sdk_click_monitor_url");
                          localObject3 = ((ansf)localObject1).getAttribute("media_duration");
                          if (aqmr.isEmpty((String)localObject3)) {}
                        }
                      }
                      catch (NumberFormatException localNumberFormatException11)
                      {
                        try
                        {
                          this.dMd = Integer.parseInt((String)localObject3);
                          localObject3 = ((ansf)localObject1).getAttribute("video_file_size");
                          if (aqmr.isEmpty((String)localObject3)) {}
                        }
                        catch (NumberFormatException localNumberFormatException11)
                        {
                          try
                          {
                            this.dMe = Integer.parseInt((String)localObject3);
                            localObject3 = ((ansf)localObject1).getAttribute("app_score_num");
                            if (aqmr.isEmpty((String)localObject3)) {}
                          }
                          catch (NumberFormatException localNumberFormatException11)
                          {
                            try
                            {
                              this.dMf = Integer.parseInt((String)localObject3);
                              localObject3 = ((ansf)localObject1).getAttribute("download_num");
                              if (aqmr.isEmpty((String)localObject3)) {}
                            }
                            catch (NumberFormatException localNumberFormatException11)
                            {
                              try
                              {
                                for (;;)
                                {
                                  Object localObject3;
                                  this.dMg = Integer.parseInt((String)localObject3);
                                  this.chE = ((ansf)localObject1).getAttribute("universal_link");
                                  this.chF = ((ansf)localObject1).getAttribute("ext_json");
                                  this.chG = ((ansf)localObject1).getAttribute("tencent_video_id");
                                  this.Wj = ((ansf)localObject1).getAttribute("view_id");
                                  int k = paramansf.Ks();
                                  int i = 0;
                                  for (;;)
                                  {
                                    if (i >= k) {
                                      break label1343;
                                    }
                                    localObject3 = paramansf.a(i);
                                    if (localObject3 != null) {
                                      break;
                                    }
                                    label1031:
                                    i += 1;
                                  }
                                  localNumberFormatException1 = localNumberFormatException1;
                                  this.dMh = 0;
                                  continue;
                                  localNumberFormatException2 = localNumberFormatException2;
                                  this.dMi = 0;
                                  continue;
                                  this.dMj = Integer.parseInt(localNumberFormatException2);
                                  continue;
                                  localIllegalArgumentException = localIllegalArgumentException;
                                  if (QLog.isColorLevel())
                                  {
                                    QLog.i("AbsStructMsgItem", 2, "Item bg value is " + this.dMj);
                                    continue;
                                    localNumberFormatException5 = localNumberFormatException5;
                                    this.dLY = 0;
                                    continue;
                                    localNumberFormatException6 = localNumberFormatException6;
                                    this.dLZ = 0;
                                    continue;
                                    localNumberFormatException7 = localNumberFormatException7;
                                    this.dMa = 0;
                                    continue;
                                    localNumberFormatException3 = localNumberFormatException3;
                                    this.dMb = 0;
                                    continue;
                                    localNumberFormatException8 = localNumberFormatException8;
                                    this.cdl = 0;
                                    continue;
                                    localNumberFormatException4 = localNumberFormatException4;
                                    this.dMc = 0;
                                    continue;
                                    localNumberFormatException9 = localNumberFormatException9;
                                    this.dMd = 0;
                                    continue;
                                    localNumberFormatException10 = localNumberFormatException10;
                                    this.dMe = 0;
                                  }
                                }
                                localNumberFormatException11 = localNumberFormatException11;
                                this.dMf = 0;
                              }
                              catch (NumberFormatException localNumberFormatException12)
                              {
                                for (;;)
                                {
                                  this.dMg = 0;
                                }
                                if ("item".equals(localNumberFormatException12.name)) {}
                                for (Object localObject2 = localNumberFormatException12.getAttribute("layout");; localObject2 = anrd.a(localNumberFormatException12.name))
                                {
                                  try
                                  {
                                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
                                    for (int j = Integer.parseInt((String)localObject2);; j = 0)
                                    {
                                      localObject2 = anrd.a(j);
                                      bool1 = bool2;
                                      if (localObject2 == null) {
                                        break;
                                      }
                                      bool1 = bool2;
                                      if (!((anqu)localObject2).a(localNumberFormatException12)) {
                                        break;
                                      }
                                      a((anqu)localObject2);
                                      break label1031;
                                    }
                                    if (!QLog.isColorLevel()) {
                                      break;
                                    }
                                  }
                                  catch (NumberFormatException paramansf)
                                  {
                                    bool1 = bool2;
                                  }
                                  QLog.i("AbsStructMsgItem", 2, "Item layout value is " + 0);
                                  return false;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1343:
    return true;
  }
  
  public void aU(String paramString1, String paramString2, String paramString3)
  {
    b(paramString1, paramString2, paramString3, 0, "0");
  }
  
  public boolean ayW()
  {
    return getStyle() == 1;
  }
  
  public abstract View b(Context paramContext, View paramView, Bundle paramBundle);
  
  public void b(AbsShareMsg paramAbsShareMsg)
  {
    Iterator localIterator = this.rz.iterator();
    while (localIterator.hasNext()) {
      ((anqu)localIterator.next()).b(paramAbsShareMsg);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.dMi = paramInt;
    a(new ansr(paramString1, paramString4));
    a(new StructMsgItemTitle(paramString2));
    a(new anux(paramString3));
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.dMi = paramInt;
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      a(new StructMsgItemTitle(paramString2));
    }
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      a(new ansr(paramString1));
    }
    if ((paramString3 != null) && (!paramString3.equals(""))) {
      a(new anux(paramString3));
    }
    if ((paramString4 != null) && (!paramString4.equals(""))) {
      a(new anuu(paramString4, paramString5));
    }
  }
  
  public void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.dMi = paramInt;
    a(new ansr(paramString1, paramString3));
    a(new StructMsgItemTitle(""));
  }
  
  public String getLayoutStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(getName()).append(this.dMi);
    if (this.rz != null)
    {
      Iterator localIterator = this.rz.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((anqu)localIterator.next()).getLayoutStr());
      }
    }
    return localStringBuffer.toString();
  }
  
  public abstract String getName();
  
  public void hF(View paramView)
  {
    if (!TextUtils.isEmpty(this.ku)) {}
    switch (getStyle())
    {
    default: 
      return;
    case 0: 
      paramView.setBackgroundResource(2130838397);
      return;
    case 1: 
      paramView.setBackgroundResource(2130838398);
      return;
    case 2: 
      paramView.setBackgroundResource(2130838396);
      return;
    }
    paramView.setBackgroundResource(2130838395);
  }
  
  public void hG(View paramView)
  {
    if (!TextUtils.isEmpty(this.ku))
    {
      Object localObject = paramView.getLayoutParams();
      int i = paramView.getPaddingLeft();
      int j = paramView.getPaddingTop();
      int k = paramView.getPaddingRight();
      int m = paramView.getPaddingBottom();
      switch (getStyle())
      {
      default: 
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setPadding(i, j, k, m);
        localObject = paramView.findViewById(2131369004);
        if ((localObject != null) && ((localObject instanceof PAHighLightImageView))) {
          ((PAHighLightImageView)localObject).dIv();
        }
        break;
      }
    }
    do
    {
      return;
      paramView.setBackgroundResource(2130838397);
      break;
      paramView.setBackgroundResource(2130838398);
      break;
      paramView.setBackgroundResource(2130838396);
      break;
      paramView.setBackgroundResource(2130838395);
      break;
      paramView = paramView.findViewById(2131378845);
    } while ((paramView == null) || (!(paramView instanceof PAHighLightImageView)));
    ((PAHighLightImageView)paramView).dIv();
  }
  
  public void hH(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    int j;
    int k;
    int m;
    if (!TextUtils.isEmpty(this.ku))
    {
      localLayoutParams = paramView.getLayoutParams();
      i = paramView.getPaddingLeft();
      j = paramView.getPaddingTop();
      k = paramView.getPaddingRight();
      m = paramView.getPaddingBottom();
      switch (getStyle())
      {
      }
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(i, j, k, m);
      return;
      paramView.setBackgroundResource(2130838409);
      continue;
      paramView.setBackgroundResource(2130838412);
      continue;
      paramView.setBackgroundResource(2130838408);
      continue;
      paramView.setBackgroundResource(2130838411);
    }
  }
  
  @TargetApi(16)
  protected void hI(View paramView)
  {
    if ((ayV()) && (ayW())) {
      switch (this.dMj)
      {
      default: 
        if ((paramView != null) && (getStyle() == 1))
        {
          if (this.dMk == 0) {
            break label128;
          }
          paramView.setBackgroundResource(this.dMk);
        }
        break;
      }
    }
    label128:
    StateListDrawable localStateListDrawable;
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(this.ku))
        {
          this.dMk = 2130838399;
          break;
        }
        this.dMk = 2130838413;
        break;
        if (!TextUtils.isEmpty(this.ku))
        {
          this.dMk = 2130838400;
          break;
        }
        this.dMk = 2130838414;
        break;
        paramView.setBackgroundResource(2130838398);
        return;
      } while ((!ayW()) || (this.dMj == 0));
      int i = wja.dp2px(4.0F, paramView.getResources());
      float f1 = i;
      float f2 = i;
      float f3 = i;
      float f4 = i;
      localStateListDrawable = ansi.a(paramView.getResources(), this.dMj, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F });
    } while (localStateListDrawable == null);
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(localStateListDrawable);
      return;
    }
    paramView.setBackground(localStateListDrawable);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    this.mVersion = paramObjectInput.readInt();
    int k;
    int i;
    String str;
    Object localObject;
    if ((this.mVersion > 0) && (this.mVersion <= 16))
    {
      this.ku = paramObjectInput.readUTF();
      this.cgX = paramObjectInput.readUTF();
      this.cgY = paramObjectInput.readUTF();
      this.cgZ = paramObjectInput.readUTF();
      this.cha = paramObjectInput.readUTF();
      this.chb = paramObjectInput.readUTF();
      this.dMh = paramObjectInput.readInt();
      this.dMi = paramObjectInput.readInt();
      if ((2 <= this.mVersion) && (this.mVersion <= 16)) {
        this.dMj = paramObjectInput.readInt();
      }
      int m = paramObjectInput.readInt();
      k = 0;
      i = 1;
      if (k < m)
      {
        str = paramObjectInput.readUTF();
        if ("item".equals(str)) {
          localObject = anrd.a(paramObjectInput.readInt());
        }
      }
    }
    for (;;)
    {
      label182:
      str = getName();
      if ((str != null) && (localObject != null) && ((localObject instanceof ansr)))
      {
        if ((!str.endsWith("Layout4")) && (!str.endsWith("Layout2")) && (!str.endsWith("Layout9"))) {
          break label354;
        }
        ((ansr)localObject).mPicWidth = ansr.dMr;
      }
      int j;
      for (;;)
      {
        if (localObject != null)
        {
          ((anqu)localObject).e = this.e;
          ((anqu)localObject).readExternal(paramObjectInput);
          a((anqu)localObject);
        }
        k += 1;
        break;
        localObject = anrd.a(str);
        j = i;
        if ("button".equals(str))
        {
          ((anqu)localObject).chH = String.valueOf(i);
          ((anqu)localObject).uin = this.uin;
          j = i + 1;
        }
        if ((localObject == null) || (!anqv.class.isInstance(localObject))) {
          break label998;
        }
        paramObjectInput.readInt();
        i = j;
        break label182;
        label354:
        if (str.endsWith("Layout3")) {
          ((ansr)localObject).mPicWidth = ansr.dMs;
        }
      }
      if ((this.mVersion >= 3) && (this.mVersion <= 16))
      {
        this.chc = paramObjectInput.readUTF();
        if (this.mVersion > 5)
        {
          this.index = paramObjectInput.readUTF();
          this.index_name = paramObjectInput.readUTF();
          this.index_type = paramObjectInput.readUTF();
        }
        if (this.mVersion > 8) {
          this.mCommonData = paramObjectInput.readUTF();
        }
        if (this.mVersion > 9)
        {
          this.che = paramObjectInput.readUTF();
          this.chf = paramObjectInput.readUTF();
          this.chg = paramObjectInput.readUTF();
          this.chd = paramObjectInput.readUTF();
          this.chh = paramObjectInput.readUTF();
        }
        if (this.mVersion > 10)
        {
          this.dLY = paramObjectInput.readInt();
          this.chi = paramObjectInput.readUTF();
          this.chj = paramObjectInput.readUTF();
          this.chk = paramObjectInput.readUTF();
          this.chl = paramObjectInput.readUTF();
          this.chm = paramObjectInput.readUTF();
          this.dLZ = paramObjectInput.readInt();
          this.chn = paramObjectInput.readUTF();
          this.cho = paramObjectInput.readUTF();
          this.chp = paramObjectInput.readUTF();
          this.chq = paramObjectInput.readUTF();
          this.chr = paramObjectInput.readUTF();
          this.dMa = paramObjectInput.readInt();
          this.chs = paramObjectInput.readUTF();
          this.cht = paramObjectInput.readUTF();
          this.chu = paramObjectInput.readUTF();
          this.chv = paramObjectInput.readUTF();
          this.chw = paramObjectInput.readUTF();
          this.mAppName = paramObjectInput.readUTF();
          this.chx = paramObjectInput.readUTF();
          this.mPkgName = paramObjectInput.readUTF();
          this.chy = paramObjectInput.readUTF();
        }
        if (this.mVersion > 11)
        {
          this.chz = paramObjectInput.readUTF();
          this.bWQ = paramObjectInput.readUTF();
          this.chA = paramObjectInput.readUTF();
        }
        if (this.mVersion > 12)
        {
          this.Wm = paramObjectInput.readUTF();
          this.Wn = paramObjectInput.readUTF();
        }
        if (this.mVersion > 13) {
          this.dMb = paramObjectInput.readInt();
        }
        if (this.mVersion > 14)
        {
          this.cdl = paramObjectInput.readInt();
          this.dMc = paramObjectInput.readInt();
        }
        if (this.mVersion > 15)
        {
          this.chB = paramObjectInput.readUTF();
          this.chC = paramObjectInput.readUTF();
          this.chD = paramObjectInput.readUTF();
          this.dMd = paramObjectInput.readInt();
          this.dMe = paramObjectInput.readInt();
          this.dMf = paramObjectInput.readInt();
          this.dMg = paramObjectInput.readInt();
          this.chE = paramObjectInput.readUTF();
          this.chF = paramObjectInput.readUTF();
          this.chG = paramObjectInput.readUTF();
          this.Wj = paramObjectInput.readUTF();
        }
      }
      return;
      throw new IOException("structmsg_version_error");
      label998:
      i = j;
    }
  }
  
  public int t(Context paramContext, int paramInt)
  {
    return (int)(TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics()) + 0.5F);
  }
  
  public void t(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    b(paramString1, paramString2, paramString3, paramInt, "0");
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(this.mTypeName);
    paramObjectOutput.writeInt(this.bvK);
    paramObjectOutput.writeInt(this.mVersion);
    if (this.ku == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.cgX != null) {
        break label252;
      }
      localObject = "";
      label59:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.cgY != null) {
        break label260;
      }
      localObject = "";
      label77:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.cgZ != null) {
        break label268;
      }
      localObject = "";
      label95:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.cha != null) {
        break label276;
      }
      localObject = "";
      label113:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.chb != null) {
        break label284;
      }
    }
    label260:
    label268:
    label276:
    label284:
    for (Object localObject = "";; localObject = this.chb)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.dMh);
      paramObjectOutput.writeInt(this.dMi);
      paramObjectOutput.writeInt(this.dMj);
      paramObjectOutput.writeInt(this.rz.size());
      QLog.i("getStructMsgFromXmlBuff", 2, "mVersion: " + this.mVersion);
      localObject = this.rz.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((anqu)((Iterator)localObject).next()).writeExternal(paramObjectOutput);
      }
      localObject = this.ku;
      break;
      label252:
      localObject = this.cgX;
      break label59;
      localObject = this.cgY;
      break label77;
      localObject = this.cgZ;
      break label95;
      localObject = this.cha;
      break label113;
    }
    if ((this.mVersion >= 3) && (this.mVersion <= 16))
    {
      if (this.chc != null) {
        break label1226;
      }
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mVersion > 5)
      {
        if (this.index != null) {
          break label1234;
        }
        localObject = "";
        label346:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.index_name != null) {
          break label1242;
        }
        localObject = "";
        label364:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.index_type != null) {
          break label1250;
        }
        localObject = "";
        label382:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.mVersion > 8)
      {
        if (this.mCommonData != null) {
          break label1258;
        }
        localObject = "";
        label409:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.mVersion > 9)
      {
        if (this.che != null) {
          break label1266;
        }
        localObject = "";
        label436:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chf != null) {
          break label1274;
        }
        localObject = "";
        label454:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chg != null) {
          break label1282;
        }
        localObject = "";
        label472:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chd != null) {
          break label1290;
        }
        localObject = "";
        label490:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chh != null) {
          break label1298;
        }
        localObject = "";
        label508:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.mVersion > 10)
      {
        paramObjectOutput.writeInt(this.dLY);
        if (this.chi != null) {
          break label1306;
        }
        localObject = "0";
        label544:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chj != null) {
          break label1314;
        }
        localObject = "0";
        label561:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chk != null) {
          break label1322;
        }
        localObject = "";
        label579:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chl != null) {
          break label1330;
        }
        localObject = "";
        label597:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chm != null) {
          break label1338;
        }
        localObject = "";
        label615:
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.dLZ);
        if (this.chn != null) {
          break label1346;
        }
        localObject = "";
        label643:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.cho != null) {
          break label1354;
        }
        localObject = "";
        label661:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chp != null) {
          break label1362;
        }
        localObject = "";
        label679:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chq != null) {
          break label1370;
        }
        localObject = "";
        label697:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chr != null) {
          break label1378;
        }
        localObject = "";
        label715:
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.dMa);
        if (this.chs != null) {
          break label1386;
        }
        localObject = "";
        label743:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.cht != null) {
          break label1394;
        }
        localObject = "";
        label761:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chu != null) {
          break label1402;
        }
        localObject = "";
        label779:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chv != null) {
          break label1410;
        }
        localObject = "";
        label797:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chw != null) {
          break label1418;
        }
        localObject = "";
        label815:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.mAppName != null) {
          break label1426;
        }
        localObject = "";
        label833:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chx != null) {
          break label1434;
        }
        localObject = "";
        label851:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.mPkgName != null) {
          break label1442;
        }
        localObject = "";
        label869:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chy != null) {
          break label1450;
        }
        localObject = "";
        label887:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.mVersion > 11)
      {
        if (this.chz != null) {
          break label1458;
        }
        localObject = "";
        label914:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.bWQ != null) {
          break label1466;
        }
        localObject = "";
        label932:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chA != null) {
          break label1474;
        }
        localObject = "";
        label950:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.mVersion > 12)
      {
        if (this.Wm != null) {
          break label1482;
        }
        localObject = "";
        label977:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.Wn != null) {
          break label1490;
        }
        localObject = "";
        label995:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.mVersion > 13) {
        paramObjectOutput.writeInt(this.dMb);
      }
      if (this.mVersion > 14)
      {
        paramObjectOutput.writeInt(this.cdl);
        paramObjectOutput.writeInt(this.dMc);
      }
      if (this.mVersion > 15)
      {
        if (this.chB != null) {
          break label1498;
        }
        localObject = "";
        label1070:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chC != null) {
          break label1506;
        }
        localObject = "";
        label1088:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chD != null) {
          break label1514;
        }
        localObject = "";
        label1106:
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.dMd);
        paramObjectOutput.writeInt(this.dMe);
        paramObjectOutput.writeInt(this.dMf);
        paramObjectOutput.writeInt(this.dMg);
        if (this.chE != null) {
          break label1522;
        }
        localObject = "";
        label1164:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chF != null) {
          break label1530;
        }
        localObject = "";
        label1182:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.chG != null) {
          break label1538;
        }
        localObject = "";
        label1200:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.Wj != null) {
          break label1546;
        }
      }
    }
    label1282:
    label1546:
    for (localObject = "";; localObject = this.Wj)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      label1226:
      localObject = this.chc;
      break;
      label1234:
      localObject = this.index;
      break label346;
      label1242:
      localObject = this.index_name;
      break label364;
      label1250:
      localObject = this.index_type;
      break label382;
      label1258:
      localObject = this.mCommonData;
      break label409;
      label1266:
      localObject = this.che;
      break label436;
      label1274:
      localObject = this.chf;
      break label454;
      localObject = this.chg;
      break label472;
      label1290:
      localObject = this.chd;
      break label490;
      label1298:
      localObject = this.chh;
      break label508;
      label1306:
      localObject = this.chi;
      break label544;
      label1314:
      localObject = this.chj;
      break label561;
      label1322:
      localObject = this.chk;
      break label579;
      label1330:
      localObject = this.chl;
      break label597;
      label1338:
      localObject = this.chm;
      break label615;
      label1346:
      localObject = this.chn;
      break label643;
      label1354:
      localObject = this.cho;
      break label661;
      label1362:
      localObject = this.chp;
      break label679;
      label1370:
      localObject = this.chq;
      break label697;
      label1378:
      localObject = this.chr;
      break label715;
      label1386:
      localObject = this.chs;
      break label743;
      label1394:
      localObject = this.cht;
      break label761;
      label1402:
      localObject = this.chu;
      break label779;
      localObject = this.chv;
      break label797;
      label1418:
      localObject = this.chw;
      break label815;
      label1426:
      localObject = this.mAppName;
      break label833;
      label1434:
      localObject = this.chx;
      break label851;
      label1442:
      localObject = this.mPkgName;
      break label869;
      label1450:
      localObject = this.chy;
      break label887;
      label1458:
      localObject = this.chz;
      break label914;
      label1466:
      localObject = this.bWQ;
      break label932;
      label1474:
      localObject = this.chA;
      break label950;
      label1482:
      localObject = this.Wm;
      break label977;
      label1490:
      localObject = this.Wn;
      break label995;
      label1498:
      localObject = this.chB;
      break label1070;
      label1506:
      localObject = this.chC;
      break label1088;
      label1514:
      localObject = this.chD;
      break label1106;
      label1522:
      localObject = this.chE;
      break label1164;
      label1530:
      localObject = this.chF;
      break label1182;
      localObject = this.chG;
      break label1200;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqv
 * JD-Core Version:    0.7.0.1
 */