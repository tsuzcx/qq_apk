import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.qphone.base.util.QLog;

public class lst
  extends NativeText
{
  protected float jq = 0.0F;
  
  public lst(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative.setBackgroundColor(paramVafContext.getContext().getResources().getColor(2131167595));
  }
  
  private String S(String paramString1, String paramString2)
  {
    return String.format(paramString1, new Object[] { paramString2 });
  }
  
  public void em(long paramLong)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new lsv(this, String.valueOf(paramLong)));
    if (localReadInJoyUserInfo != null)
    {
      setText(kxm.ew(localReadInJoyUserInfo.nick));
      return;
    }
    setText(ReadInJoyUserInfoModule.getDefaultNickName());
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if (this.jq > 0.0F) {
      this.mNative.setLineSpacing(this.jq, 1.0F);
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramString);
      try
      {
        this.jq = Utils.dp2px(Double.valueOf(paramString).doubleValue());
        return true;
      }
      catch (Exception localException)
      {
        QLog.d("ReadInjoyTextView", 1, "", localException);
      }
    }
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lst(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lst
 * JD-Core Version:    0.7.0.1
 */