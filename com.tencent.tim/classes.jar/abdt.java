import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.a;

public abstract class abdt
  extends PinnedHeaderExpandableListView.a
  implements aqdf.a, AbsListView.e
{
  protected ExpandableListView b;
  private aqdf jdField_e_of_type_Aqdf;
  private final QQAppInterface jdField_e_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Context mContext;
  
  public abdt(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.mContext = paramContext;
    this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramExpandableListView;
    this.jdField_e_of_type_Aqdf = new aqdf(this.mContext, this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_e_of_type_Aqdf.a(this);
    aqhu.G();
  }
  
  protected void a(abeg.a parama, Bitmap paramBitmap)
  {
    a(parama, paramBitmap, true);
  }
  
  protected void a(abeg.a parama, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (parama.pQ == null) {
      return;
    }
    if (acbn.bkw.equals(parama.uin))
    {
      parama.pQ.setBackgroundResource(2130845074);
      return;
    }
    if (acbn.bkx.equals(parama.uin))
    {
      parama.pQ.setBackgroundResource(2130845071);
      return;
    }
    if (acbn.bky.equals(parama.uin))
    {
      parama.pQ.setBackgroundResource(2130845077);
      return;
    }
    if (acbn.bkv.equals(parama.uin))
    {
      parama.pQ.setBackgroundResource(2130840081);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_e_of_type_Aqdf.b(parama.type, parama.uin);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = aqhu.G();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_e_of_type_Aqdf.isPausing())
        {
          this.jdField_e_of_type_Aqdf.i(parama.uin, parama.type, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      parama.pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), localBitmap));
      return;
    }
  }
  
  public void destroy()
  {
    if (this.jdField_e_of_type_Aqdf != null) {
      this.jdField_e_of_type_Aqdf.destory();
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return null;
  }
  
  public int getGroupCount()
  {
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int gj()
  {
    return 0;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void j(View paramView, int paramInt) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_e_of_type_Aqdf.isPausing()) && (paramBitmap != null)) {
      p(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_e_of_type_Aqdf.edu();
      this.jdField_e_of_type_Aqdf.pause();
    }
    while (!this.jdField_e_of_type_Aqdf.isPausing()) {
      return;
    }
    this.jdField_e_of_type_Aqdf.edu();
    this.jdField_e_of_type_Aqdf.resume();
    p(null, null);
  }
  
  protected void p(String paramString, Bitmap paramBitmap)
  {
    int j = this.b.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.b.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof abeg.a)))
      {
        localObject = (abeg.a)localObject;
        if (paramString != null) {
          break label69;
        }
        a((abeg.a)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((abeg.a)localObject).uin))
      {
        i += 1;
        break;
      }
      ((abeg.a)localObject).pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdt
 * JD-Core Version:    0.7.0.1
 */