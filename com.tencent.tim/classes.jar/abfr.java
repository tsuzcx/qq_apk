import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.RobotAdapter.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class abfr
  extends BaseAdapter
  implements aqdf.a
{
  acnd b = new abfw(this);
  private boolean bCh;
  public View.OnClickListener bJ = new abfs(this);
  private AbsListView.e c = new abfv(this);
  private FragmentActivity jdField_d_of_type_AndroidSupportV4AppFragmentActivity;
  private aqdf jdField_d_of_type_Aqdf;
  public View.OnClickListener eM = new abft(this);
  private ArrayList<abfr.a> iM = new ArrayList();
  private QQAppInterface mAppInterface;
  private int mScrollState = 0;
  private String mTroopUin;
  private ArrayList<String> sH = new ArrayList();
  private ListView t;
  
  public abfr(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, ListView paramListView, String paramString, boolean paramBoolean)
  {
    this.mAppInterface = paramQQAppInterface;
    this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.t = paramListView;
    this.mTroopUin = paramString;
    this.bCh = paramBoolean;
    f(paramQQAppInterface);
    paramListView.setOnScrollListener(this.c);
    this.mAppInterface.addObserver(this.b);
  }
  
  private View e(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561749, null);
      if (paramViewGroup != null)
      {
        localObject = (TextView)paramViewGroup.findViewById(2131370343);
        if (localObject != null)
        {
          ((TextView)localObject).setText(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131721538));
          ((TextView)localObject).setContentDescription(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131721538));
        }
        return paramViewGroup;
      }
      break;
    case 2: 
      return LayoutInflater.from(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561748, null);
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561750, null);
      if (paramViewGroup != null)
      {
        localObject = new abfr.b();
        ((abfr.b)localObject).mD = ((ImageView)paramViewGroup.findViewById(2131368375));
        ((abfr.b)localObject).name = ((TextView)paramViewGroup.findViewById(2131372190));
        ((abfr.b)localObject).description = ((TextView)paramViewGroup.findViewById(2131365748));
        Button localButton = (Button)paramViewGroup.findViewById(2131362194);
        ((abfr.b)localObject).aI = localButton;
        ((abfr.b)localObject).xn = ((ImageView)paramViewGroup.findViewById(2131372314));
        paramViewGroup.setTag(localObject);
        paramViewGroup.setOnClickListener(this.bJ);
        localButton.setOnClickListener(this.eM);
      }
      return paramViewGroup;
    }
    return paramViewGroup;
  }
  
  private void f(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new RobotAdapter.5(this, paramString, paramBoolean, paramInt));
  }
  
  private void m(int paramInt, View paramView)
  {
    switch (getItemViewType(paramInt))
    {
    }
    abfr.a locala;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getItem(paramInt);
        } while (!(localObject instanceof abfr.a));
        locala = (abfr.a)localObject;
      } while (paramView == null);
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof abfr.b)));
    abfr.b localb = (abfr.b)paramView;
    String str = String.valueOf(locala.a.getUin());
    Object localObject = this.jdField_d_of_type_Aqdf.b(1, str);
    paramView = (View)localObject;
    if (localObject == null)
    {
      localObject = aqhu.G();
      paramView = (View)localObject;
      if (!this.jdField_d_of_type_Aqdf.isPausing())
      {
        this.jdField_d_of_type_Aqdf.i(str, 1, false);
        paramView = (View)localObject;
      }
    }
    localb.mD.setImageBitmap(paramView);
    localb.name.setText(locala.a.getName());
    localb.description.setText(locala.a.getDesc());
    localb.uin = str;
    localb.aI.setTag(str);
    localb.mD.setContentDescription(locala.a.getName());
    localb.description.setContentDescription(locala.a.getDesc());
    paramView = (aptw)this.mAppInterface.getManager(203);
    if (paramView != null) {}
    for (boolean bool = paramView.e(this.mAppInterface, str, this.mTroopUin);; bool = false)
    {
      if (bool) {
        localb.xn.setVisibility(0);
      }
      while (this.sH.contains(str))
      {
        localb.aI.setEnabled(false);
        localb.aI.setContentDescription(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131695459));
        return;
        localb.xn.setVisibility(8);
      }
      localb.aI.setEnabled(true);
      localb.aI.setContentDescription(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131721053));
      return;
    }
  }
  
  private void q(String paramString, Bitmap paramBitmap)
  {
    int j = this.t.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.t.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof abfr.b)))
        {
          localObject = (abfr.b)localObject;
          if ((paramString != null) && (TextUtils.equals(paramString, ((abfr.b)localObject).uin))) {
            ((abfr.b)localObject).mD.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void destroy()
  {
    this.jdField_d_of_type_Aqdf.destory();
    this.mAppInterface.removeObserver(this.b);
    this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void f(AppInterface paramAppInterface)
  {
    if (this.jdField_d_of_type_Aqdf == null)
    {
      this.jdField_d_of_type_Aqdf = new aqdf(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity, paramAppInterface);
      this.jdField_d_of_type_Aqdf.a(this);
    }
  }
  
  public int getCount()
  {
    if (this.iM != null)
    {
      if (this.iM.size() == 0) {
        return 2;
      }
      return this.iM.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.iM != null) && (this.iM.size() > 0) && (paramInt >= 1)) {
      return this.iM.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.iM == null) || (this.iM.size() == 0)) {
      if (paramInt != 0) {}
    }
    while (paramInt == 0)
    {
      return 0;
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = e(paramInt, paramViewGroup);
    }
    for (;;)
    {
      m(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    q(paramString, paramBitmap);
  }
  
  public void setData(ArrayList<aptv> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.iM.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        abfr.a locala = new abfr.a((aptv)paramArrayList.get(i));
        this.iM.add(locala);
        i += 1;
      }
      QLog.d("RobotAdapter", 2, "setData arrayList" + paramArrayList.size());
      super.notifyDataSetChanged();
      return;
    }
    QLog.e("RobotAdapter", 2, "setData null");
  }
  
  public void showToast(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    String str = this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692457);
    switch (paramInt)
    {
    }
    for (;;)
    {
      QQToast.a(BaseApplication.getContext(), 0, str, 1).show();
      return;
      str = this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131694088);
      continue;
      str = this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131694089);
      continue;
      str = this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692445);
      continue;
      str = this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693281);
    }
  }
  
  class a
  {
    aptv a;
    Boolean ak;
    
    public a(aptv paramaptv)
    {
      this.a = paramaptv;
      this.ak = Boolean.valueOf(false);
    }
  }
  
  class b
  {
    Button aI;
    TextView description;
    ImageView mD;
    TextView name;
    String uin;
    ImageView xn;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfr
 * JD-Core Version:    0.7.0.1
 */