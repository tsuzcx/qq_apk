import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.a;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.List;

public class afnm
  implements aiad.a, View.OnTouchListener, AbsListView.e
{
  private aiad jdField_a_of_type_Aiad = new aiad(120, this);
  private EmotionPanelListView.a jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a;
  private EmotionPanelListView b;
  boolean bZH = false;
  private boolean bZI;
  private int cSx;
  private int cSy;
  private float downY;
  private AbsListView.e h;
  private int[] kZ = new int[2];
  private int mLastState = 0;
  private int mLastTop;
  private int spacing;
  
  public afnm(EmotionPanelListView paramEmotionPanelListView, EmotionPanelListView.a parama, AbsListView.e parame)
  {
    this.h = parame;
    this.b = paramEmotionPanelListView;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a = parama;
    this.spacing = aqnm.dip2px(5.0F);
    this.jdField_a_of_type_Aiad.PK(30);
  }
  
  private void ML(int paramInt)
  {
    if (paramInt != this.mLastState)
    {
      if ((this.b.getChildAt(0) != null) && (paramInt == 0) && (this.mLastState != 1) && (b(this.b)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a != null) && (this.b.getListViewScrollY() < this.mLastTop) && (this.bZH))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a.cZv();
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelListView", 2, "onScrollStateChanged onPullDown");
        }
      }
      this.mLastState = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelListView", 2, "onScrollStateChanged mLastState :" + this.mLastState);
      }
    }
  }
  
  private void b(AbsListView paramAbsListView, boolean paramBoolean)
  {
    if (paramAbsListView != null)
    {
      int k = paramAbsListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = paramAbsListView.getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = m - 1;
          if (j >= 0)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(m - 1);
            localView2.getLocationOnScreen(this.kZ);
            this.kZ[0] = localView2.getLeft();
            if ((paramBoolean) && (this.cSy > 0) && (this.kZ[0] + localView2.getWidth() * 2.0F / 3.0F > this.cSy) && (this.cSx > 0) && (this.kZ[1] + localView2.getWidth() - this.spacing > this.cSx)) {
              gv(localView2);
            }
            for (;;)
            {
              j -= 1;
              break;
              localView2.setAlpha(1.0F);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private boolean b(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramListView.getChildCount() > 0)
    {
      bool1 = bool2;
      if (paramListView.getFirstVisiblePosition() == 0)
      {
        bool1 = bool2;
        if (paramListView.getChildAt(0) != null)
        {
          bool1 = bool2;
          if (paramListView.getChildAt(0).getTop() >= paramListView.getPaddingTop()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void gv(View paramView)
  {
    if ((paramView instanceof URLImageView))
    {
      int i = this.kZ[1] + paramView.getWidth() - this.spacing - this.cSx;
      float f = paramView.getWidth() / 2.0F;
      if (i < f)
      {
        paramView.setAlpha((f - i) * 1.0F / f);
        return;
      }
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(1.0F);
  }
  
  public void Ia(boolean paramBoolean)
  {
    this.bZI = paramBoolean;
  }
  
  public void Ib(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a.cZu();
      this.jdField_a_of_type_Aiad.KQ(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListView", 2, "onCheckSpeed overSpeed :" + paramBoolean);
    }
  }
  
  public aiad a()
  {
    return this.jdField_a_of_type_Aiad;
  }
  
  public void m(AbsListView paramAbsListView)
  {
    if (this.bZI) {}
    while ((!(paramAbsListView.getAdapter() instanceof afqq)) && (!(paramAbsListView.getAdapter() instanceof afqj))) {
      return;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a instanceof EmoticonMainPanel)) && (((EmoticonMainPanel)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a).a().a != null))
    {
      int i = EmoticonPanelController.cSe;
      List localList = ((EmoticonMainPanel)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a).a().zZ;
      EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = ((EmoticonMainPanel)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a).a().a;
      if ((i >= 0) && (localList != null) && (i < localList.size()))
      {
        Object localObject2 = localEmotionPanelViewPagerAdapter.a(i);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (i - 1 >= 0) {
            localObject1 = localEmotionPanelViewPagerAdapter.a(i - 1);
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (i + 1 < localList.size()) {
            localObject2 = localEmotionPanelViewPagerAdapter.a(i + 1);
          }
        }
        if ((localObject2 != null) && (((ImageButton)localObject2).getVisibility() == 0))
        {
          localObject1 = new int[2];
          ((ImageButton)localObject2).getLocationOnScreen((int[])localObject1);
          this.cSy = ((ImageButton)localObject2).getLeft();
          this.cSx = localObject1[1];
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      b(paramAbsListView, bool);
      return;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.h != null) {
      this.h.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((b(this.b)) && (this.mLastState == 2) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a != null)) {
      ML(0);
    }
    m(paramAbsListView);
    this.mLastTop = this.b.getListViewScrollY();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.h != null) {
      this.h.onScrollStateChanged(paramAbsListView, paramInt);
    }
    ML(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.downY = paramMotionEvent.getY();
      this.jdField_a_of_type_Aiad.KQ(true);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a != null) {
        this.bZH = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a.ajy();
      }
    }
    for (;;)
    {
      return false;
      if ((i == 1) && (this.bZH)) {
        if ((b(this.b)) && (this.b.getListViewScrollY() < this.mLastTop) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a.cZv();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch scroll top pull down");
          }
        }
        else if ((b(this.b)) && (paramMotionEvent.getY() > this.downY) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$a.cZv();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch no scroll top pull down");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnm
 * JD-Core Version:    0.7.0.1
 */