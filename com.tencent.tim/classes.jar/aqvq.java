import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.mobileqq.vip.diy.ProfileTemplateNickNameContainer;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqvq
  extends awlz
{
  private String bWn = "";
  private String cye = "";
  private int mFontId = -1;
  private int mFontType = -1;
  
  public aqvq(String paramString1, View paramView, String paramString2)
  {
    super(paramString1, paramView);
    this.bWn = paramString2;
  }
  
  protected void RC()
  {
    super.RC();
    if ((this.ey instanceof ProfileTemplateNickNameContainer))
    {
      ETTextViewPlus localETTextViewPlus = ((ProfileTemplateNickNameContainer)this.ey).a();
      if ((this.mFontId <= 0) || (this.mFontType <= 0)) {
        break label112;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "set name font id=" + this.mFontId + " type=" + this.mFontType);
      }
      localETTextViewPlus.setFontAsync(this.mFontId, this.mFontType);
    }
    for (;;)
    {
      ((ProfileTemplateNickNameContainer)this.ey).setTextBgUrl(this.cye);
      return;
      label112:
      ram.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "profile nick name set font error because font id=" + this.mFontId + " type=" + this.mFontType + " is illegal!");
    }
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    paramLayoutParams.width = -1;
    paramLayoutParams.height = -2;
    int i = ((ViewGroup.MarginLayoutParams)paramLayoutParams).leftMargin;
    ((ViewGroup.MarginLayoutParams)paramLayoutParams).leftMargin = 0;
    if ((this.ey instanceof ProfileTemplateNickNameContainer))
    {
      ProfileTemplateNickNameContainer localProfileTemplateNickNameContainer = (ProfileTemplateNickNameContainer)this.ey;
      localProfileTemplateNickNameContainer.setTextViewX(i);
      if ("center_horizontal".equals(paramJSONObject.optString("gravity"))) {
        localProfileTemplateNickNameContainer.setTextCenter();
      }
    }
    return paramLayoutParams;
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    if ("f".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        this.mFontId = Integer.parseInt(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "parse name font id=" + this.mFontId);
        }
        return;
      }
      catch (NumberFormatException paramString1)
      {
        ram.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "pf_name font id illegal :" + paramString2 + " error=" + paramString1);
        return;
      }
      if ("ft".equals(paramString1)) {
        try
        {
          this.mFontType = Integer.parseInt(paramString2);
          if (QLog.isColorLevel())
          {
            QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "parse name font type=" + this.mFontType);
            return;
          }
        }
        catch (NumberFormatException paramString1)
        {
          ram.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "pf_name font type illegal :" + paramString2 + " error=" + paramString1);
          return;
        }
      }
    }
    if ("bg".equals(paramString1))
    {
      this.cye = paramString2;
      return;
    }
    super.setAttribute(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvq
 * JD-Core Version:    0.7.0.1
 */