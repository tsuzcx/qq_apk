import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class aflu
  extends afnz
{
  public aflu(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, afmf paramafmf, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf, paramInt4);
    this.f = paramafmf;
    this.bZT = true;
  }
  
  public afll.a a()
  {
    return new aflu.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (aflu.a)parama;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label662;
      }
      parama = afos.a().getView(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (parama == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
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
        QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
      }
      break;
      if (paramView == null)
      {
        paramView = afos.a().getView(6);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
          }
          paramView = new EmoticonPanelLinearLayout(this.mContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramView.setOrientation(0);
          if (paramInt == 1) {
            paramView.setPadding(0, (int)(16.0F * this.density), 0, 0);
          }
          for (;;)
          {
            i = 0;
            for (;;)
            {
              parama = paramView;
              if (i >= this.TL) {
                break;
              }
              parama = super.m();
              parama.setVisibility(8);
              paramView.addView(parama);
              i += 1;
            }
            paramView.setPadding(0, (int)(14.0F * this.density), 0, 0);
          }
        }
        parama = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
          parama = paramView;
        }
        ((EmoticonPanelLinearLayout)parama).setCallBack(this.f);
        recycleView(6, parama);
        paramView = (ViewGroup)parama;
        paramViewGroup.h = new RelativeLayout[this.TL];
        i = 0;
        while (i < this.TL)
        {
          paramViewGroup.h[i] = ((RelativeLayout)paramView.getChildAt(i));
          i += 1;
        }
        parama.setTag(paramViewGroup);
        i = j;
      }
      for (;;)
      {
        paramView = parama;
        if (i >= this.TL) {
          break;
        }
        j = this.TL * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.h[i].setTag(null);
          paramViewGroup.h[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          super.a(paramViewGroup.h[i], (afom)this.data.get(j));
        }
        parama = paramView;
        i = j;
      }
      label662:
      parama = paramView;
    }
  }
  
  public static class a
    extends afnz.a
  {
    public RelativeLayout[] h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflu
 * JD-Core Version:    0.7.0.1
 */