import android.content.Context;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyLabelInfo;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

public class akht
{
  private View Fn;
  private LabelContainer a;
  private View hY;
  private QQAppInterface mApp;
  private Context mContext;
  private boolean xv;
  
  public View a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 16777216) {
      i = paramInt1 - 16777216;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 16777216) {
      paramInt1 = paramInt2 - 16777216;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-7829368);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      localObject = URLDrawable.getDrawable(paramString1, (URLDrawable.URLDrawableOptions)localObject);
      paramString1 = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        if (QLog.isColorLevel()) {
          QLog.w("TopicLabelCtrl", 2, "getDrawable exception, exp=" + localException + ", url=" + paramString1);
        }
        paramString1 = new ColorDrawable(-7829368);
      }
    }
    localObject = new View(this.mContext);
    ((View)localObject).setBackgroundDrawable(paramString1);
    localLinearLayout.addView((View)localObject, riw.dip2px(this.mContext, 18.0F), riw.dip2px(this.mContext, 15.0F));
    ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).leftMargin = riw.dip2px(this.mContext, 4.0F);
    paramString1 = new TextView(this.mContext);
    paramString1.setText(paramString2);
    paramString1.setTextSize(14.0F);
    paramString1.setTextColor(i);
    localLinearLayout.addView(paramString1);
    paramString1 = (LinearLayout.LayoutParams)paramString1.getLayoutParams();
    paramString1.rightMargin = riw.dip2px(this.mContext, 6.0F);
    paramString1.leftMargin = riw.dip2px(this.mContext, 2.0F);
    localLinearLayout.setBackgroundResource(2130846469);
    paramString1 = localLinearLayout.getBackground();
    if (paramString1 != null)
    {
      paramString1.setColorFilter(new LightingColorFilter(-16777216, paramInt1));
      paramString1.invalidateSelf();
    }
    localLinearLayout.setOnClickListener(new akhu(this));
    return localLinearLayout;
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, boolean paramBoolean)
  {
    this.mApp = paramQQAppInterface;
    this.xv = paramBoolean;
    this.hY = paramView.findViewById(2131379867);
    this.a = ((LabelContainer)paramView.findViewById(2131370297));
    this.Fn = paramView.findViewById(2131370491);
    this.mContext = paramView.getContext();
  }
  
  public void a(cmd0xac5.NearbyNowData paramNearbyNowData)
  {
    if (this.a.getChildCount() > 0) {
      this.a.removeAllViews();
    }
    this.a.setSpace(riw.dip2px(this.mContext, 6.0F), riw.dip2px(this.mContext, 8.0F));
    if (paramNearbyNowData != null) {}
    for (paramNearbyNowData = paramNearbyNowData.label_info.get();; paramNearbyNowData = null)
    {
      if ((paramNearbyNowData != null) && (paramNearbyNowData.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TopicLabelCtrl", 2, "updateData, nearbyLabelInfoList.size=" + paramNearbyNowData.size());
        }
        int i = 0;
        while (i < paramNearbyNowData.size())
        {
          Object localObject = (cmd0xac5.NearbyLabelInfo)paramNearbyNowData.get(i);
          localObject = a(((cmd0xac5.NearbyLabelInfo)localObject).label_pic.get().toStringUtf8(), ((cmd0xac5.NearbyLabelInfo)localObject).label_name.get().toStringUtf8(), ((cmd0xac5.NearbyLabelInfo)localObject).font_colour.get(), ((cmd0xac5.NearbyLabelInfo)localObject).label_colour.get());
          this.a.addView((View)localObject, -2, riw.dip2px(this.mContext, 24.0F));
          i += 1;
        }
        this.a.setVisibility(0);
        return;
      }
      this.hY.setVisibility(8);
      this.Fn.setVisibility(8);
      this.a.setVisibility(8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akht
 * JD-Core Version:    0.7.0.1
 */