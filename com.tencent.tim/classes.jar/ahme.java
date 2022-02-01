import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ahme
{
  public static int TYPE_NORMAL;
  public static int cZX = 1;
  private ahme.a jdField_a_of_type_Ahme$a;
  private aqdf.a jdField_a_of_type_Aqdf$a = new ahmg(this);
  private aqdf jdField_a_of_type_Aqdf;
  private acnd b = new ahmf(this);
  private GridLayoutManager c;
  private RelativeLayout ff;
  private QQAppInterface mApp;
  private Context mContext;
  private RecyclerView mRecyclerView;
  private float mScale = 1.0F;
  private RecyclerView.OnScrollListener mScrollListener = new ahmh(this);
  private String mTroopUin = "";
  private TextView ny;
  
  public ahme(Context paramContext)
  {
    this.mContext = paramContext;
    init();
  }
  
  private void Kg(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new ForwardTroopMemberControllerForMiniPie.1(this, paramString));
  }
  
  private void hideLoading()
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.setVisibility(0);
    }
    if (this.ny != null) {
      this.ny.setVisibility(4);
    }
  }
  
  private void init()
  {
    int i = 5;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.ff == null)
    {
      this.ff = new RelativeLayout(this.mContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.ff.setLayoutParams(localLayoutParams);
    }
    if (this.ny == null)
    {
      this.ny = new TextView(this.mContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(15);
      this.ny.setLayoutParams(localLayoutParams);
      this.ny.setText(acfp.m(2131706559));
      int j = (int)(16.0D / this.mScale);
      this.ny.setTextSize(2, j);
      this.ny.setTextColor(this.mContext.getResources().getColor(2131167395));
    }
    if (this.mRecyclerView == null)
    {
      this.mRecyclerView = new RecyclerView(this.mContext);
      this.c = new GridLayoutManager(this.mContext, 5);
      this.mRecyclerView.setLayoutManager(this.c);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      if (this.mScale != 0.0F) {
        i = (int)(5 / this.mScale);
      }
      i = wja.dp2px(i, this.mContext.getResources());
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      this.mRecyclerView.setLayoutParams(localLayoutParams);
      this.mRecyclerView.setOverScrollMode(2);
    }
    if (this.ff != null)
    {
      this.ff.addView(this.mRecyclerView);
      this.ff.addView(this.ny);
    }
  }
  
  private void showLoading()
  {
    if (this.ny != null) {
      this.ny.setVisibility(0);
    }
    if (this.mRecyclerView != null) {
      this.mRecyclerView.setVisibility(4);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, float paramFloat)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "setTroopInfo  uin: " + paramString);
    this.mApp = paramQQAppInterface;
    paramQQAppInterface = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramQQAppInterface = "";
    }
    this.mTroopUin = paramQQAppInterface;
    if (this.mApp != null) {
      this.mApp.addObserver(this.b);
    }
    this.jdField_a_of_type_Aqdf = new aqdf(this.mApp);
    this.jdField_a_of_type_Aqdf.a(this.jdField_a_of_type_Aqdf$a);
    this.mScale = paramFloat;
    this.jdField_a_of_type_Ahme$a = new ahme.a(this.mContext, this.jdField_a_of_type_Aqdf, this.mScale);
    this.mRecyclerView.setAdapter(this.jdField_a_of_type_Ahme$a);
    this.mRecyclerView.addOnScrollListener(this.mScrollListener);
    showLoading();
    if (paramInt == 1) {
      ((acms)this.mApp.getBusinessHandler(20)).Ff(this.mTroopUin);
    }
    while (paramInt != 3000) {
      return;
    }
    Kg(this.mTroopUin);
  }
  
  public void destroy()
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "destroy.");
    if (this.mApp != null) {
      this.mApp.removeObserver(this.b);
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    this.mApp = null;
  }
  
  public View getView()
  {
    return this.ff;
  }
  
  public static class a
    extends RecyclerView.Adapter<ahme.c>
  {
    List<Pair<String, String>> BZ;
    aqdf c;
    Context context;
    float scale = 1.0F;
    
    public a(Context paramContext, aqdf paramaqdf, float paramFloat)
    {
      this.context = paramContext;
      this.c = paramaqdf;
      this.BZ = new ArrayList();
      this.scale = paramFloat;
    }
    
    public ahme.c a(ViewGroup paramViewGroup, int paramInt)
    {
      if (paramInt == ahme.cZX)
      {
        paramViewGroup = new View(this.context);
        int i = this.context.getResources().getDimensionPixelSize(2131297369);
        paramInt = i;
        if (this.scale != 0.0F) {
          paramInt = (int)(i / this.scale);
        }
        paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
        return new ahme.c(paramViewGroup);
      }
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131559344, paramViewGroup, false);
      if ((this.scale != 0.0F) && (paramViewGroup != null))
      {
        Object localObject1 = paramViewGroup.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = wja.dp2px(80.0F / this.scale, this.context.getResources());
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (ImageView)paramViewGroup.findViewById(2131369092);
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = ((ImageView)localObject1).getLayoutParams();
          if (localObject2 != null)
          {
            paramInt = wja.dp2px(40.0F / this.scale, this.context.getResources());
            ((ViewGroup.LayoutParams)localObject2).width = paramInt;
            ((ViewGroup.LayoutParams)localObject2).height = paramInt;
            ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        localObject1 = (TextView)paramViewGroup.findViewById(2131381146);
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextSize(2, (int)(10.0D / this.scale));
          localObject2 = (ViewGroup.MarginLayoutParams)((TextView)localObject1).getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject2).setMargins((int)(((ViewGroup.MarginLayoutParams)localObject2).leftMargin / this.scale), (int)(((ViewGroup.MarginLayoutParams)localObject2).topMargin / this.scale), (int)(((ViewGroup.MarginLayoutParams)localObject2).rightMargin / this.scale), (int)(((ViewGroup.MarginLayoutParams)localObject2).bottomMargin / this.scale));
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      return new ahme.b(paramViewGroup);
    }
    
    public void a(ahme.c paramc, int paramInt)
    {
      if (paramc.viewType == ahme.cZX) {}
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramc, paramInt, getItemId(paramInt));
        return;
        if (paramc.viewType == ahme.TYPE_NORMAL)
        {
          int i = paramInt - 1;
          if (i < 0) {
            QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "type normal in wrong index");
          }
          Pair localPair = (Pair)this.BZ.get(i);
          if ((paramc instanceof ahme.b)) {
            ((ahme.b)paramc).a((String)localPair.first, (String)localPair.second, this.c);
          }
        }
      }
    }
    
    public int getItemCount()
    {
      if ((this.BZ == null) || (this.BZ.size() == 0)) {
        return 0;
      }
      return this.BZ.size() + 1;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt == 0) {
        return ahme.cZX;
      }
      return ahme.TYPE_NORMAL;
    }
    
    public void kT(List<Pair<String, String>> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return;
      }
      this.BZ.clear();
      this.BZ.addAll(paramList);
      notifyDataSetChanged();
    }
    
    public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
    {
      super.onAttachedToRecyclerView(paramRecyclerView);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof GridLayoutManager)) {
        ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new ahmi(this));
      }
    }
  }
  
  static class b
    extends ahme.c
  {
    public TextView To;
    public ImageView zU;
    
    public b(View paramView)
    {
      super();
      this.viewType = ahme.TYPE_NORMAL;
      this.zU = ((ImageView)paramView.findViewById(2131369092));
      this.To = ((TextView)paramView.findViewById(2131381146));
      paramView.setTag(this);
    }
    
    public void a(String paramString1, String paramString2, aqdf paramaqdf)
    {
      Object localObject = paramString2;
      if (paramString2 == null) {
        localObject = paramString1;
      }
      this.To.setText(new aofk((CharSequence)localObject, 2));
      localObject = paramaqdf.b(1, paramString1);
      paramString2 = (String)localObject;
      if (localObject == null)
      {
        localObject = aqhu.G();
        paramString2 = (String)localObject;
        if (!paramaqdf.isPausing())
        {
          paramaqdf.i(paramString1, 1, false);
          paramString2 = (String)localObject;
        }
      }
      this.zU.setImageBitmap(paramString2);
    }
  }
  
  static class c
    extends RecyclerView.ViewHolder
  {
    public int viewType = ahme.cZX;
    
    public c(View paramView)
    {
      super();
      paramView.setTag(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahme
 * JD-Core Version:    0.7.0.1
 */