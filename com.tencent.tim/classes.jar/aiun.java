import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.HeadSetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class aiun
  extends BaseAdapter
  implements aqdf.a
{
  private List<String> CG;
  private QQAppInterface app;
  private final HeadSetView b;
  private Context context;
  private aitg e;
  private final HorizontalListView u;
  
  protected static final <T extends View> T $(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public aiun(QQAppInterface paramQQAppInterface, Context paramContext, HorizontalListView paramHorizontalListView, HeadSetView paramHeadSetView)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.u = paramHorizontalListView;
    this.b = paramHeadSetView;
    this.CG = new ArrayList();
  }
  
  private void ll(@NonNull List<String> paramList)
  {
    this.CG = paramList;
  }
  
  public void d(aitg paramaitg)
  {
    this.e = paramaitg;
    this.e.a(this);
  }
  
  public int getCount()
  {
    if (this.e == null) {
      return 0;
    }
    return this.CG.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.CG.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131559467, null);
      paramView = new aiun.a(localView);
      if (QLog.isColorLevel()) {
        QLog.d("HeadAdapter", 2, new Object[] { "getView: invoked. ", " position: ", Integer.valueOf(paramInt) });
      }
      paramView.uin = str;
      localView.setTag(paramView);
    }
    for (;;)
    {
      localView.setOnClickListener(new aiuo(this, str));
      Bitmap localBitmap = this.e.E(paramView.uin);
      Object localObject = localBitmap;
      if (localBitmap == null) {
        localObject = aqhu.G();
      }
      paramView.AZ.setImageBitmap((Bitmap)localObject);
      aitz.p(localView, aqgv.d(this.app, str, 0) + "正在共享位置");
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aiun.a)paramView.getTag();
      ((aiun.a)localObject).uin = str;
      localView = paramView;
      paramView = (View)localObject;
    }
  }
  
  public void lm(@NonNull List<String> paramList)
  {
    if ((this.CG.equals(paramList)) && (QLog.isColorLevel())) {
      QLog.d("HeadAdapter", 2, new Object[] { "notifyDataSetChangedAdvance: invoked. same list, ", " newHeadSetList: ", paramList, " headSetList: ", this.CG });
    }
    ll(paramList);
    if (this.CG.size() <= this.b.FW()) {
      this.u.setOverScrollMode(1);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      this.u.setOverScrollMode(0);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.u.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.u.getChildAt(paramInt1).getTag();
        if (!(localObject instanceof aiun.a)) {
          break label87;
        }
        localObject = (aiun.a)localObject;
        if ((paramString == null) || (!paramString.equals(((aiun.a)localObject).uin))) {
          break label87;
        }
        if (paramBitmap != null)
        {
          paramString = this.e.E(paramString);
          if (paramString != null) {
            ((aiun.a)localObject).AZ.setImageBitmap(paramString);
          }
        }
      }
      return;
      label87:
      paramInt1 += 1;
    }
  }
  
  static class a
  {
    ImageView AZ;
    String uin;
    
    public a(View paramView)
    {
      this.AZ = ((ImageView)aiun.$(paramView, 2131370850));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiun
 * JD-Core Version:    0.7.0.1
 */