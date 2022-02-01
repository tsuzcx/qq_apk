import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class afql
  extends afnz
{
  protected int cTg = (this.widthPixels - (int)(18.0F * this.density) * 8) / 7;
  
  public afql(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, afmf paramafmf, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf, paramInt4);
    this.bZT = true;
  }
  
  public afll.a a()
  {
    return new afql.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (afql.a)parama;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label751;
      }
      parama = afos.a().getView(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (parama == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
        }
        parama = LayoutInflater.from(this.mContext).inflate(2131562097, null);
        parama.setLayoutParams(paramView);
        parama.setPadding(0, (int)(10.0F * this.density), 0, 0);
        recycleView(7, parama);
        paramViewGroup.d = ((URLImageView)parama.findViewById(2131365477));
        paramViewGroup.name = ((TextView)parama.findViewById(2131365572));
        paramViewGroup.a = ((ProgressButton)parama.findViewById(2131365570));
        parama.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a(paramViewGroup);
      paramView = parama;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
      }
      break;
      Object localObject;
      if (paramView == null)
      {
        paramView = afos.a().getView(2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
          }
          paramView = new EmoticonPanelLinearLayout(this.mContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramView.setOrientation(0);
          paramView.setPadding(0, (int)(this.density * 18.0F), 0, 0);
          i = 0;
          for (;;)
          {
            parama = paramView;
            if (i >= this.TL) {
              break;
            }
            parama = new URLImageView(this.mContext);
            localObject = new LinearLayout.LayoutParams(this.cTg, this.cTg);
            ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.density * 18.0F));
            parama.setLayoutParams((ViewGroup.LayoutParams)localObject);
            parama.setVisibility(8);
            parama.setScaleType(ImageView.ScaleType.FIT_XY);
            parama.setAdjustViewBounds(false);
            paramView.addView(parama);
            i += 1;
          }
        }
        parama = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
          parama = paramView;
        }
        ((EmoticonPanelLinearLayout)parama).setCallBack(this.f);
        recycleView(2, parama);
        paramView = (ViewGroup)parama;
        paramViewGroup.b = new URLImageView[this.TL];
        i = 0;
        while (i < this.TL)
        {
          paramViewGroup.b[i] = ((URLImageView)paramView.getChildAt(i));
          i += 1;
        }
        parama.setTag(paramViewGroup);
      }
      for (;;)
      {
        i = 0;
        paramView = parama;
        if (i >= this.TL) {
          break;
        }
        int j = this.TL * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.b[i].setTag(null);
          paramViewGroup.b[i].setVisibility(8);
        }
        label744:
        for (;;)
        {
          i += 1;
          break;
          localObject = paramViewGroup.b[i];
          paramView = (afom)this.data.get(j);
          if ((paramView instanceof afmi)) {}
          for (paramView = (afmi)paramView;; paramView = null)
          {
            if (paramView == null) {
              break label744;
            }
            paramViewGroup.b[i].setTag(paramView);
            paramViewGroup.b[i].setOnClickListener(this);
            ((URLImageView)localObject).setImageDrawable(paramView.b(this.mContext, this.density));
            ((URLImageView)localObject).setVisibility(0);
            break;
          }
        }
        parama = paramView;
      }
      label751:
      parama = paramView;
    }
  }
  
  public static class a
    extends afnz.a
  {
    public URLImageView[] b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afql
 * JD-Core Version:    0.7.0.1
 */