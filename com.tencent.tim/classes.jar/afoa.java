import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class afoa
  extends afll
{
  private List<String> Ad = new ArrayList();
  protected final BaseChatPie mBaseChatPie;
  
  public afoa(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, afmf paramafmf, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private URLImageView a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionHotPicSearchAdapter", 2, "getCameraEmoView");
    }
    int i = (int)(this.widthPixels - 2.0F * this.density * (this.TL - 1));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i / this.TL, i / this.TL);
    if (paramInt == 0)
    {
      localLayoutParams.rightMargin = ((int)(this.density * 1.0F));
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      URLImageView localURLImageView = new URLImageView(this.mContext);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localURLImageView.setAdjustViewBounds(false);
      localURLImageView.setLayoutParams(localLayoutParams);
      localURLImageView.setContentDescription(this.mContext.getString(2131692253));
      return localURLImageView;
      if (paramInt == this.TL - 1)
      {
        localLayoutParams.leftMargin = ((int)(this.density * 1.0F));
        localLayoutParams.rightMargin = 0;
        localLayoutParams.width = -1;
      }
      else
      {
        localLayoutParams.rightMargin = ((int)(this.density * 1.0F));
        localLayoutParams.leftMargin = ((int)(this.density * 1.0F));
      }
    }
  }
  
  private void a(afom paramafom, int paramInt)
  {
    if ((!(paramafom instanceof afpm)) || (((afpm)paramafom).a == null)) {}
    do
    {
      do
      {
        String str;
        do
        {
          return;
          str = ((afpm)paramafom).a.getEmoMd5();
        } while (this.Ad.contains(str));
        this.Ad.add(str);
      } while (this.mBaseChatPie == null);
      if ((((afpm)paramafom).mPageType == 1) && (this.mBaseChatPie.a() != null))
      {
        int i = ((afnh)this.mBaseChatPie.a().a().a(5)).sZ();
        if (i != 0) {
          anot.a(this.mBaseChatPie.app, "dc00898", "", "", "0X800AE1D", "0X800AE1D", i, 0, "2", "", ((afpm)paramafom).a.getEmoMd5(), String.valueOf(paramInt + 1));
        }
        anot.a(this.mBaseChatPie.app, "dc00898", "", "", "0X800AE2D", "0X800AE2D", 0, 0, "2", "", ((afpm)paramafom).a.getEmoMd5(), String.valueOf(paramInt + 1));
        return;
      }
    } while (((afpm)paramafom).mPageType != 2);
    anot.a(this.mBaseChatPie.app, "dc00898", "", "", "0X800AE35", "0X800AE35", RichTextPanel.dcd, 0, "2", "", ((afpm)paramafom).a.getEmoMd5(), String.valueOf(paramInt + 1));
  }
  
  private void a(View paramView, afom paramafom, int paramInt)
  {
    if ((paramView == null) || (!(paramafom instanceof afmi))) {
      QLog.e("EmotionHotPicSearchAdapter", 1, "emotionInfo or contentView = null");
    }
    URLImageView localURLImageView;
    afmi localafmi;
    do
    {
      return;
      localURLImageView = (URLImageView)paramView;
      localafmi = (afmi)paramafom;
      paramView.setTag(localafmi);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!aqmr.isEmpty(localafmi.action))) {
        QLog.d("EmotionHotPicSearchAdapter", 2, "updateUI info = " + localafmi.action);
      }
    } while (localURLImageView.getTag(2131381960) == paramafom);
    a(paramafom, paramInt);
    localURLImageView.setTag(2131381960, paramafom);
    localURLImageView.setVisibility(0);
    localURLImageView.setURLDrawableDownListener(null);
    paramView = localafmi.c(this.mContext, this.density);
    if ((paramView instanceof URLDrawable)) {
      localURLImageView.setURLDrawableDownListener(new afob(this, localafmi));
    }
    localURLImageView.setImageDrawable(paramView);
  }
  
  public afll.a a()
  {
    return new afoa.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (afoa.a)parama;
    int i;
    if (paramView == null)
    {
      paramView = afos.a().getView(this.panelType);
      parama = paramView;
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionHotPicSearchAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, -1);
        paramView.setPanelType(EmoticonPanelLinearLayout.cSu);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(2.0F * this.density), 0, 0);
        i = 0;
        for (;;)
        {
          parama = paramView;
          if (i >= this.TL) {
            break;
          }
          parama = a(i);
          parama.setVisibility(8);
          parama.setFocusable(true);
          parama.setFocusableInTouchMode(true);
          paramView.addView(parama);
          i += 1;
        }
      }
      ((EmoticonPanelLinearLayout)parama).setCallBack(this.f);
      recycleView(this.panelType, parama);
      paramView = (ViewGroup)parama;
      paramViewGroup.b = new URLImageView[this.TL];
      i = 0;
      while (i < this.TL)
      {
        paramViewGroup.b[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      parama.setTag(paramViewGroup);
      i = j;
    }
    for (;;)
    {
      if (i < this.TL)
      {
        j = this.TL * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.b[i].setTag(null);
          paramViewGroup.b[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          a(paramViewGroup.b[i], (afom)this.data.get(j), j);
        }
      }
      return parama;
      parama = paramView;
      i = j;
    }
  }
  
  public void daL()
  {
    this.Ad.clear();
  }
  
  public static class a
    extends afll.a
  {
    URLImageView[] b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoa
 * JD-Core Version:    0.7.0.1
 */