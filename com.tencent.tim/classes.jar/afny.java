import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XPanelContainer;

public class afny
  extends afnz
  implements View.OnClickListener
{
  protected int cSH;
  
  public afny(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, afmf paramafmf, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf, paramInt4);
    this.bZT = false;
    this.cSH = (XPanelContainer.aLe - (int)paramContext.getResources().getDimension(2131297202));
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.a = ((afnz.a)parama);
    if (paramView == null)
    {
      parama = afos.a().getView(this.panelType);
      paramView = new AbsListView.LayoutParams(-1, this.cSH);
      if (parama == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        parama = LayoutInflater.from(this.mContext).inflate(2131562097, null);
        parama.setLayoutParams(paramView);
        this.a.d = ((URLImageView)parama.findViewById(2131365477));
        this.a.name = ((TextView)parama.findViewById(2131365572));
        this.a.a = ((ProgressButton)parama.findViewById(2131365570));
        recycleView(this.panelType, parama);
        parama.setTag(this.a);
      }
    }
    for (;;)
    {
      a(this.a);
      paramInt = XPanelContainer.aLe - (int)this.mContext.getResources().getDimension(2131297202);
      if (paramInt != this.cSH)
      {
        this.cSH = paramInt;
        paramView = (AbsListView.LayoutParams)parama.getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.cSH;
          parama.setLayoutParams(paramView);
        }
      }
      return parama;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      parama = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.d;
  }
  
  public int getCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afny
 * JD-Core Version:    0.7.0.1
 */