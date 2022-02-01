package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import amxk;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import aqgo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import kbp;
import kwt;
import kxm;
import lie;
import mas;
import mci;
import ndi;
import odv;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;

public class ComponentHeaderSubscribe
  extends ComponentHeaderBase
{
  private FixSizeImageView e;
  private View kM;
  private TextView qC;
  
  public ComponentHeaderSubscribe(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderSubscribe(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderSubscribe(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aOk()
  {
    Object localObject = this.jdField_a_of_type_Mas.a;
    if (((lie)localObject).oF() == 3)
    {
      this.kM.setVisibility(0);
      if (!((lie)localObject).a().mSubscribeInfoObj.bytes_test.has()) {}
    }
    label163:
    for (;;)
    {
      try
      {
        localObject = ((lie)localObject).a().mSubscribeInfoObj.bytes_test.get().toStringUtf8();
        if (((String)localObject).length() <= 4) {
          break label163;
        }
        localObject = ((String)localObject).substring(0, 4);
        ((TextView)this.kM).setText((CharSequence)localObject);
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(((String)localObject).trim())))
        {
          this.kM.setVisibility(8);
          return;
        }
        this.kM.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        QLog.w("ComponentHeaderSubscribe", 1, "read field error", localException);
        this.kM.setVisibility(0);
        return;
      }
      this.kM.setVisibility(0);
      return;
      this.kM.setVisibility(8);
      return;
    }
  }
  
  private void aOl()
  {
    String str = kwt.acJ + aqgo.encodeToString(String.valueOf(getUin()).getBytes(), 2);
    kxm.aJ(getContext(), str);
    doReport();
  }
  
  private void doReport()
  {
    try
    {
      JSONObject localJSONObject = kxm.v();
      localJSONObject.put("feeds_source", kxm.f(this.jdField_a_of_type_Mas.a.a()));
      localJSONObject.put("kandian_mode", kxm.nR());
      String str2 = kxm.g(this.jdField_a_of_type_Mas.a.a());
      if (odv.aT(this.jdField_a_of_type_Mas.a.nh())) {}
      for (String str1 = "0X8009357";; str1 = "0X800744D")
      {
        kbp.a(null, "CliOper", "", "", str1, str1, 0, 0, str2, "", "", localJSONObject.toString(), false);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private long getUin()
  {
    if (this.jdField_a_of_type_Mas.a.oF() == 3) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_Mas.a.a().mSubscribeID);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return 0L;
  }
  
  private void setTitle()
  {
    this.qC.setText(kxm.ew(this.jdField_a_of_type_Mas.a.a().mSubscribeName));
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie)) {
      d((lie)paramObject);
    }
  }
  
  public void aNf()
  {
    super.aNf();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(8);
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.e = ((FixSizeImageView)findViewById(2131376673));
    this.qC = ((TextView)findViewById(2131376689));
    this.kM = findViewById(2131378991);
  }
  
  public void d(lie paramlie)
  {
    if ((paramlie.isShowHeader()) && (paramlie.oF() == 3)) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramlie.isShowHeader()) && (paramlie.oF() == 3))
      {
        setImage();
        setTitle();
        aOk();
      }
      return;
    }
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560333, this, true);
  }
  
  public void setImage()
  {
    long l = getUin();
    if (l != 0L)
    {
      if (!kxm.AI()) {
        break label52;
      }
      this.e.setImageDrawable(amxk.b(this.jdField_a_of_type_Aqdf, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.e.setOnClickListener(new mci(this));
      return;
      label52:
      this.e.setImageBitmap(this.b.c(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe
 * JD-Core Version:    0.7.0.1
 */