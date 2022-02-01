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
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ahjl
  extends ahjf
{
  public static int TYPE_NORMAL;
  public static int cZX = 1;
  private ahjl.a jdField_a_of_type_Ahjl$a;
  private aqdf.a jdField_a_of_type_Aqdf$a = new ahjn(this);
  private aqdf jdField_a_of_type_Aqdf;
  private acnd b = new ahjm(this);
  private GridLayoutManager c;
  private QQAppInterface mApp;
  private RecyclerView mRecyclerView;
  private RecyclerView.OnScrollListener mScrollListener = new ahjo(this);
  private String mTroopUin = "";
  
  public ahjl(aqju paramaqju)
  {
    super(paramaqju);
  }
  
  private void Kg(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new ForwardPreviewTroopMemberController.1(this, paramString));
  }
  
  protected int EZ()
  {
    return 380;
  }
  
  protected View getContentView()
  {
    if (this.mRecyclerView == null)
    {
      this.mRecyclerView = new RecyclerView(this.mContext);
      this.c = new GridLayoutManager(this.mContext, 5);
      this.mRecyclerView.setLayoutManager(this.c);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      int i = wja.dp2px(5.0F, this.mContext.getResources());
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      this.mRecyclerView.setLayoutParams(localLayoutParams);
      this.mRecyclerView.setOverScrollMode(2);
    }
    return this.mRecyclerView;
  }
  
  public void k(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "bindData title: " + paramString1 + " uin: " + paramString2);
    this.mApp = paramQQAppInterface;
    paramQQAppInterface = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramQQAppInterface = "";
    }
    this.mTroopUin = paramQQAppInterface;
    dQ(paramString1);
    this.mApp.addObserver(this.b);
    this.jdField_a_of_type_Aqdf = new aqdf(this.mApp);
    this.jdField_a_of_type_Aqdf.a(this.jdField_a_of_type_Aqdf$a);
    this.jdField_a_of_type_Ahjl$a = new ahjl.a(this.mApp, this.mContext, this.jdField_a_of_type_Aqdf);
    this.mRecyclerView.setAdapter(this.jdField_a_of_type_Ahjl$a);
    this.mRecyclerView.addOnScrollListener(this.mScrollListener);
    showLoadingView();
    if (paramInt == 1) {
      ((acms)this.mApp.getBusinessHandler(20)).Ff(this.mTroopUin);
    }
    while (paramInt != 3000) {
      return;
    }
    Kg(this.mTroopUin);
  }
  
  protected void onDestroy()
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDestroy.");
    this.mApp.removeObserver(this.b);
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
  }
  
  public static class a
    extends RecyclerView.Adapter<ahjl.c>
  {
    List<Pair<String, String>> BZ;
    QQAppInterface app;
    aqdf c;
    Context context;
    
    public a(QQAppInterface paramQQAppInterface, Context paramContext, aqdf paramaqdf)
    {
      this.app = paramQQAppInterface;
      this.context = paramContext;
      this.c = paramaqdf;
      this.BZ = new ArrayList();
    }
    
    public ahjl.c a(ViewGroup paramViewGroup, int paramInt)
    {
      if (paramInt == ahjl.cZX)
      {
        paramViewGroup = new View(this.context);
        paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.context.getResources().getDimensionPixelSize(2131297369)));
        return new ahjl.c(paramViewGroup);
      }
      return new ahjl.b(LayoutInflater.from(this.context).inflate(2131559344, paramViewGroup, false));
    }
    
    public void a(ahjl.c paramc, int paramInt)
    {
      if (paramc.viewType == ahjl.cZX) {}
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramc, paramInt, getItemId(paramInt));
        return;
        if (paramc.viewType == ahjl.TYPE_NORMAL)
        {
          int i = paramInt - 1;
          if (i < 0) {
            QLog.e("Forward.Preview.Dialog", 2, "type normal in wrong index");
          }
          Pair localPair = (Pair)this.BZ.get(i);
          if ((paramc instanceof ahjl.b)) {
            ((ahjl.b)paramc).a((String)localPair.first, (String)localPair.second, this.c);
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
        return ahjl.cZX;
      }
      return ahjl.TYPE_NORMAL;
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
        ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new ahjp(this));
      }
    }
  }
  
  static class b
    extends ahjl.c
  {
    public TextView To;
    public ImageView zU;
    
    public b(View paramView)
    {
      super();
      this.viewType = ahjl.TYPE_NORMAL;
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
    public int viewType = ahjl.cZX;
    
    public c(View paramView)
    {
      super();
      paramView.setTag(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjl
 * JD-Core Version:    0.7.0.1
 */