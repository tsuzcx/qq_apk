import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public abstract class abdu
  extends BaseAdapter
  implements amkg.a, aqdf.a, AbsListView.e
{
  private XListView C;
  protected amkc.a a;
  private amkg jdField_a_of_type_Amkg;
  private aqdf jdField_a_of_type_Aqdf;
  boolean bBW = false;
  private int mScrollState = 0;
  private List<? extends amka> vO;
  private List<amka> vP;
  
  public abdu(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<? extends amka> paramList)
  {
    this.C = paramXListView;
    this.C.setOnScrollListener(this);
    this.jdField_a_of_type_Aqdf = new aqdf(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Aqdf.a(this);
    this.vO = paramList;
    this.vP = new ArrayList();
  }
  
  public void M(int paramInt, List<? extends amka> paramList)
  {
    this.vP.clear();
    this.vP.addAll(paramList);
    paramList.clear();
    if (this.jdField_a_of_type_Amkc$a != null) {
      this.jdField_a_of_type_Amkc$a.Uw(paramInt);
    }
    notifyDataSetChanged();
  }
  
  protected boolean a(abdu.a parama)
  {
    return (parama != null) && (!TextUtils.isEmpty(parama.uin));
  }
  
  public void cBh()
  {
    if (this.vP != null)
    {
      this.vP.clear();
      notifyDataSetChanged();
    }
  }
  
  public void destory()
  {
    if (this.jdField_a_of_type_Amkg != null) {
      this.jdField_a_of_type_Amkg.cancel(true);
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    this.C = null;
  }
  
  protected Bitmap e(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.b(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.i(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return aqhu.G();
    }
    if (paramInt == 101) {
      return aqhu.aN();
    }
    if (paramInt == 4) {
      return aqhu.aL();
    }
    if (paramInt == 11) {
      return aqhu.aH();
    }
    if (paramInt == 110) {
      return aqhu.aJ();
    }
    if (paramInt == 111) {
      return aqhu.aK();
    }
    return aqhu.G();
  }
  
  public int getCount()
  {
    if (this.vP != null) {
      return this.vP.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.vP != null) && (paramInt < this.vP.size())) {
      return this.vP.get(paramInt);
    }
    return null;
  }
  
  public void hS(List<? extends amka> paramList)
  {
    this.vP.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    int i;
    if ((!this.jdField_a_of_type_Aqdf.isPausing()) && ((this.mScrollState == 0) || (this.mScrollState == 1)))
    {
      i = this.C.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < i)
      {
        Object localObject = this.C.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof abdu.a)))
        {
          localObject = (abdu.a)localObject;
          if ((localObject != null) && (!TextUtils.isEmpty(((abdu.a)localObject).uin)) && (((abdu.a)localObject).uin.equals(paramString)) && (paramInt2 == ((abdu.a)localObject).type)) {
            ((abdu.a)localObject).xj.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.C == null) {}
    for (;;)
    {
      return;
      this.mScrollState = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_Aqdf.isPausing()) {
        this.jdField_a_of_type_Aqdf.resume();
      }
      int i = this.C.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = this.C.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof abdu.a)))
        {
          paramAbsListView = (abdu.a)paramAbsListView;
          if (a(paramAbsListView)) {
            paramAbsListView.xj.setImageBitmap(e(paramAbsListView.uin, paramAbsListView.type));
          }
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Aqdf.edu();
    this.jdField_a_of_type_Aqdf.pause();
  }
  
  public static class a
  {
    public int type = 1;
    public String uin;
    public ImageView xj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdu
 * JD-Core Version:    0.7.0.1
 */