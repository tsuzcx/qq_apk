import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter.1;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.HashMap;
import java.util.List;

public class afqq
  extends afll
{
  public boolean bZY;
  private int businessType;
  public int cRX = -1;
  protected int cTg;
  protected int cTo;
  private int cTp = -1;
  private int cTq;
  private boolean cal;
  public int cdX = -1;
  public BaseChatPie mBaseChatPie;
  
  public afqq(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, afmf paramafmf, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.businessType = paramInt4;
    this.cTg = ((int)(this.density * 30.0F));
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private int b(List<afom> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        Object localObject = (afom)paramList.get(i);
        if ((localObject instanceof afqr))
        {
          localObject = (afqr)localObject;
          if ((!((afqr)localObject).cam) && (((afqr)localObject).code == paramInt2) && ((paramInt1 == -1) || (paramInt1 == ((afqr)localObject).ahx))) {
            return i;
          }
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private int g(List<afom> paramList, int paramInt)
  {
    return b(paramList, -1, paramInt);
  }
  
  public void MZ(int paramInt)
  {
    if ((this.a != null) && (paramInt >= 0))
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.a.abordFling();
      this.a.setSelection(i);
    }
  }
  
  public void Na(int paramInt)
  {
    this.cTq = paramInt;
  }
  
  public afll.a a()
  {
    return new afqq.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.cTo = ((this.widthPixels - (int)(18.0F * this.density) * 2 - this.cTg * this.TL) / (this.TL - 1));
    long l1 = System.currentTimeMillis();
    afqq.a locala = (afqq.a)parama;
    if (getItemViewType(paramInt) == 0)
    {
      parama = paramView;
      if (paramView == null)
      {
        parama = new LinearLayout(this.mContext);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.topMargin = ((int)(6.0F * this.density));
        paramView.leftMargin = ((int)(18.0F * this.density));
        paramViewGroup = new TextView(this.mContext);
        paramViewGroup.setTextSize(8.0F);
        paramViewGroup.setTextColor(this.mContext.getResources().getColor(2131167383));
        parama.addView(paramViewGroup, paramView);
        locala.RB = paramViewGroup;
        parama.setTag(locala);
      }
      paramView = (afom)this.data.get(this.TL * paramInt);
      if (!(paramView instanceof afqr)) {
        break label1206;
      }
    }
    label1162:
    label1206:
    for (paramView = (afqr)paramView;; paramView = null)
    {
      if (paramView != null) {}
      for (paramView = paramView.title;; paramView = "")
      {
        locala.RB.setText(paramView);
        paramView = parama;
        int i;
        long l2;
        label751:
        do
        {
          if ((paramInt == getCount() - 1) && (this.cTq != 0)) {
            paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() + this.cTq);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "getEmoticonView cost = " + (System.currentTimeMillis() - l1));
          }
          return paramView;
          parama = paramView;
          if (paramView == null)
          {
            paramView = afos.a().getView(this.panelType);
            if (paramView == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
              }
              parama = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, this.businessType);
              parama.setPanelType(EmoticonPanelLinearLayout.cSo);
              parama.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
              parama.setOrientation(0);
              i = this.cTg + (int)(12.0F * this.density);
              if (paramInt == getCount() - 1) {
                i = this.cTg;
              }
              j = 0;
              if (j < this.TL)
              {
                paramView = new EmoticonImageView(this.mContext);
                paramViewGroup = new LinearLayout.LayoutParams(this.cTg, i);
                if (j == 0) {}
                for (paramViewGroup.leftMargin = ((int)(18.0F * this.density));; paramViewGroup.leftMargin = this.cTo)
                {
                  paramView.setLayoutParams(paramViewGroup);
                  paramView.setVisibility(8);
                  paramView.setScaleType(ImageView.ScaleType.FIT_START);
                  paramView.setAdjustViewBounds(false);
                  paramView.setFocusable(true);
                  paramView.setFocusableInTouchMode(true);
                  parama.addView(paramView);
                  j += 1;
                  break;
                }
              }
            }
            for (;;)
            {
              ((EmoticonPanelLinearLayout)parama).setCallBack(this.f);
              recycleView(this.panelType, parama);
              paramView = (ViewGroup)parama;
              locala.a = new EmoticonImageView[this.TL];
              i = 0;
              while (i < this.TL)
              {
                locala.a[i] = ((EmoticonImageView)paramView.getChildAt(i));
                i += 1;
              }
              parama = paramView;
              if (QLog.isColorLevel())
              {
                QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
                parama = paramView;
              }
            }
            parama.setTag(locala);
          }
          i = 0;
          if (!this.bZY) {
            break;
          }
          if (paramInt == 0) {
            i = (int)(7.0F * this.density);
          }
          parama.setPadding(0, i, 0, 0);
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "inflater view cost = " + (l2 - l1));
          }
          i = 0;
          paramView = parama;
        } while (i >= this.TL);
        int j = this.TL * paramInt + i;
        if (j > this.data.size() - 1) {
          locala.a[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break label751;
          if ((paramInt != 1) && (paramInt != 5)) {
            break;
          }
          i = (int)(7.0F * this.density);
          break;
          EmoticonImageView localEmoticonImageView = locala.a[i];
          paramViewGroup = (afom)this.data.get(j);
          paramView = null;
          if ((paramViewGroup instanceof afqr)) {
            paramView = (afqr)paramViewGroup;
          }
          if (paramView == null)
          {
            localEmoticonImageView.setVisibility(8);
          }
          else
          {
            locala.a[i].setTag(paramView);
            if (paramView.code == -1)
            {
              localEmoticonImageView.setVisibility(8);
            }
            else
            {
              localEmoticonImageView.setVisibility(0);
              if (paramViewGroup != localEmoticonImageView.getTag(2131381960))
              {
                localEmoticonImageView.setTag(2131381960, paramViewGroup);
                if (ApolloUtil.ii(paramView.code))
                {
                  localEmoticonImageView.setNewIconVisible(true);
                  ApolloUtil.It(paramView.code);
                  if ((this.mBaseChatPie != null) && (!this.cal))
                  {
                    this.cal = true;
                    paramViewGroup = this.mBaseChatPie.a();
                    if (paramViewGroup != null) {
                      ThreadManagerV2.getUIHandlerV2().postDelayed(new SystemAndEmojiAdapter.2(this, paramViewGroup), 100L);
                    }
                  }
                }
                for (;;)
                {
                  l2 = System.currentTimeMillis();
                  paramViewGroup = paramView.b(false);
                  if (QLog.isColorLevel()) {
                    QLog.d("SystemAndEmojiAdapter", 2, "getdrawable cost = " + (System.currentTimeMillis() - l2));
                  }
                  localEmoticonImageView.setImageDrawable(paramViewGroup);
                  if (paramView.ahx != 1) {
                    break label1162;
                  }
                  paramViewGroup = afky.ea(paramView.code);
                  paramView = paramViewGroup;
                  if (paramViewGroup != null)
                  {
                    paramView = paramViewGroup;
                    if (paramViewGroup.startsWith("/"))
                    {
                      paramView = paramViewGroup;
                      if (paramViewGroup.length() > 1) {
                        paramView = paramViewGroup.substring(1);
                      }
                    }
                  }
                  if (paramView == null) {
                    break;
                  }
                  localEmoticonImageView.setContentDescription(paramView);
                  break;
                  localEmoticonImageView.setNewIconVisible(false);
                }
                if (paramView.ahx == 2) {
                  localEmoticonImageView.setContentDescription(afku.dZ(paramView.code));
                } else {
                  localEmoticonImageView.setContentDescription(acfp.m(2131715097));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void dag()
  {
    super.dag();
    this.data = this.zT;
    notifyDataSetChanged();
  }
  
  public void dbA()
  {
    MZ(this.cTp);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = this.TL;
    Object localObject = (afom)this.data.get(i * paramInt);
    if ((localObject instanceof afqr)) {}
    for (localObject = (afqr)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (((afqr)localObject).ahx == 3) {
          return 0;
        }
        return 1;
      }
      return -1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void hQ(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != -1) && (this.a != null))
    {
      paramInt1 = b(this.data, paramInt1, paramInt2);
      if (paramInt1 != -1)
      {
        paramInt1 /= this.TL;
        this.a.post(new SystemAndEmojiAdapter.1(this, paramInt1));
      }
    }
  }
  
  public void setData(List<afom> paramList)
  {
    super.setData(paramList);
    this.zT = paramList;
    dag();
    if (afqv.kt.containsKey("3.4.4"))
    {
      List localList = (List)afqv.kt.get("3.4.4");
      if ((localList != null) && (localList.size() > 0))
      {
        int i = g(paramList, ((Integer)localList.get(0)).intValue());
        if (i != -1) {
          this.cTp = (i / this.TL);
        }
      }
    }
    if ((this.cRX != -1) && (this.cdX != -1) && (this.a != null))
    {
      hQ(this.cdX, this.cRX);
      this.cRX = -1;
      this.cdX = -1;
    }
  }
  
  public static class a
    extends afll.a
  {
    TextView RB;
    EmoticonImageView[] a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqq
 * JD-Core Version:    0.7.0.1
 */