import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class afqj
  extends afll
{
  private int businessType;
  protected int cTg;
  protected EmoticonPackage d;
  protected afmf f;
  BaseChatPie mBaseChatPie;
  
  public afqj(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, afmf paramafmf, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.businessType = paramInt4;
    this.d = paramEmoticonPackage;
    this.f = paramafmf;
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  public afll.a a()
  {
    return new afqj.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.cTg = ((this.widthPixels - (int)(18.0F * this.density) * (this.TL + 1)) / this.TL);
    Object localObject1 = (afqj.a)parama;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label935;
      }
      paramView = afos.a().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, this.businessType);
        paramView.setPanelType(EmoticonPanelLinearLayout.cSq);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(18.0F * this.density), 0, 0);
        i = 0;
        for (;;)
        {
          parama = paramView;
          if (i >= this.TL) {
            break;
          }
          parama = new URLImageView(this.mContext);
          paramViewGroup = new LinearLayout.LayoutParams(this.cTg, this.cTg);
          paramViewGroup.leftMargin = ((int)(18.0F * this.density));
          parama.setLayoutParams(paramViewGroup);
          parama.setVisibility(8);
          parama.setScaleType(ImageView.ScaleType.FIT_XY);
          parama.setAdjustViewBounds(false);
          parama.setFocusable(true);
          parama.setFocusableInTouchMode(true);
          paramView.addView(parama);
          i += 1;
        }
      }
      parama = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        parama = paramView;
      }
      ((EmoticonPanelLinearLayout)parama).setCallBack(this.f);
      recycleView(this.panelType, parama);
      paramView = (ViewGroup)parama;
      ((afqj.a)localObject1).b = new URLImageView[this.TL];
      i = 0;
      while (i < this.TL)
      {
        ((afqj.a)localObject1).b[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      parama.setTag(localObject1);
    }
    for (;;)
    {
      i = 0;
      paramView = parama;
      int j;
      if (i < this.TL)
      {
        j = this.TL * paramInt + i;
        if (j > this.data.size() - 1)
        {
          localObject1.b[i].setTag(null);
          localObject1.b[i].setVisibility(8);
        }
      }
      label898:
      label910:
      label921:
      label933:
      for (;;)
      {
        i += 1;
        break;
        paramViewGroup = localObject1.b[i];
        paramView = (afom)this.data.get(j);
        if ((paramView instanceof afmi)) {}
        for (paramView = (afmi)paramView;; paramView = null)
        {
          if (paramView == null) {
            break label933;
          }
          localObject1.b[i].setTag(paramView);
          paramViewGroup.setImageDrawable(paramView.b(this.mContext, this.density));
          paramViewGroup.setVisibility(0);
          break;
          if (paramView == null)
          {
            paramViewGroup = new RelativeLayout(this.mContext);
            paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(57.0F * this.density)));
            LinearLayout localLinearLayout = new LinearLayout(this.mContext);
            parama = new RelativeLayout.LayoutParams(-2, -2);
            parama.addRule(13, -1);
            localLinearLayout.setLayoutParams(parama);
            paramView = afns.a(this.d.epId, true);
            Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
            localLinearLayout.setOrientation(0);
            ((LinearLayout.LayoutParams)localObject2).gravity = 16;
            TextView localTextView = new TextView(this.mContext);
            localTextView.setTextSize(14.0F);
            if (paramView.bZQ)
            {
              parama = acfp.m(2131714626);
              localTextView.setText(parama);
              localTextView.setTextColor(-8947849);
              localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
              parama = new LinearLayout.LayoutParams(-2, -2);
              parama.leftMargin = ((int)(5.0F * this.density));
              parama.gravity = 16;
              localObject2 = new ImageView(this.mContext);
              ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847984));
              localLinearLayout.addView((View)localObject2, parama);
              paramViewGroup.addView(localLinearLayout);
              ((afqj.a)localObject1).linearLayout = localLinearLayout;
              ((afqj.a)localObject1).linearLayout.setOnClickListener(new afqk(this, paramView));
              if (this.businessType != 2) {
                break label898;
              }
              ((afqj.a)localObject1).linearLayout.setVisibility(8);
              label827:
              paramViewGroup.setTag(localObject1);
              if (this.app != null) {
                break label910;
              }
              parama = "";
              label845:
              localObject1 = this.d.epId;
              if (!paramView.bZQ) {
                break label921;
              }
            }
            for (paramView = "1";; paramView = "2")
            {
              VasWebviewUtil.reportCommercialDrainage(parama, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject1, paramView);
              paramView = paramViewGroup;
              return paramView;
              parama = acfp.m(2131714625);
              break;
              ((afqj.a)localObject1).linearLayout.setVisibility(0);
              break label827;
              parama = this.app.getCurrentAccountUin();
              break label845;
            }
          }
          return paramView;
        }
      }
      label935:
      parama = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.d;
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (this.businessType == 1) {
        return i;
      }
      return i + 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.businessType == 1) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (this.businessType == 1) {
      return 1;
    }
    return 2;
  }
  
  public static class a
    extends afll.a
  {
    URLImageView[] b;
    LinearLayout linearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqj
 * JD-Core Version:    0.7.0.1
 */