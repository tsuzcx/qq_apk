import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.DashboardAdapter.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class awyw
  extends axgh
{
  private RecyclerView F;
  private RecyclerView G;
  private RecyclerView H;
  private RecyclerView I;
  private awyw.a a;
  private CheckBox af;
  private CheckBox ag;
  private TextView agT;
  private TextView agU;
  private CheckBox ah;
  private CheckBox ai;
  private awyw.a b;
  private awtq jdField_c_of_type_Awtq;
  private awyw.a jdField_c_of_type_Awyw$a;
  private awyw.a d;
  
  public awyw(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
    this.jdField_c_of_type_Awtq = ((awtq)paramaxgi.a(65537, new Object[0]));
  }
  
  private void biN()
  {
    awyu.a().a(this.jdField_c_of_type_Awtq, new awzd(this));
  }
  
  private void eHW()
  {
    this.af.setOnCheckedChangeListener(new awyy(this));
    this.ag.setOnCheckedChangeListener(new awyz(this));
    this.ah.setOnCheckedChangeListener(new awza(this));
    this.ai.setOnCheckedChangeListener(new awzb(this));
  }
  
  private void eHX()
  {
    this.a = new awyw.a(this.mActivity);
    this.b = new awyw.a(this.mActivity);
    this.jdField_c_of_type_Awyw$a = new awyw.a(this.mActivity);
    this.d = new awyw.a(this.mActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.F.setLayoutManager(localLinearLayoutManager);
    this.F.setAdapter(this.a);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.G.setLayoutManager(localLinearLayoutManager);
    this.G.setAdapter(this.b);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.H.setLayoutManager(localLinearLayoutManager);
    this.H.setAdapter(this.jdField_c_of_type_Awyw$a);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.I.setLayoutManager(localLinearLayoutManager);
    this.I.setAdapter(this.d);
  }
  
  private void eHY()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new awzc(this));
  }
  
  protected void initView()
  {
    View localView = ((ViewStub)this.mRootView.findViewById(2131362284)).inflate();
    this.agT = ((TextView)localView.findViewById(2131362289));
    this.agU = ((TextView)localView.findViewById(2131362290));
    this.af = ((CheckBox)localView.findViewById(2131362287));
    this.ag = ((CheckBox)localView.findViewById(2131362292));
    this.ah = ((CheckBox)localView.findViewById(2131362295));
    this.ai = ((CheckBox)localView.findViewById(2131362294));
    this.F = ((RecyclerView)localView.findViewById(2131362286));
    this.G = ((RecyclerView)localView.findViewById(2131362291));
    this.H = ((RecyclerView)localView.findViewById(2131362285));
    this.I = ((RecyclerView)localView.findViewById(2131362293));
    eHW();
    eHX();
    eHY();
    this.agU.setOnClickListener(new awyx(this));
    biN();
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject3;
    if (paramInt == 720897)
    {
      localObject2 = (List)paramVarArgs[0];
      localObject1 = (List)paramVarArgs[1];
      paramVarArgs = new LinkedList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (awyu.b)((Iterator)localObject2).next();
        localc = new awyw.c(null);
        localc.mMessage = awyw.e.a((awyu.b)localObject3);
        paramVarArgs.add(localc);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (awyu.a)((Iterator)localObject1).next();
        localc = new awyw.c(null);
        localc.mMessage = ((awyu.a)localObject3).toString();
        ((List)localObject2).add(localc);
      }
      this.a.oB(paramVarArgs);
      this.jdField_c_of_type_Awyw$a.oB((List)localObject2);
    }
    while ((paramInt != 720898) || (this.d == null))
    {
      awyw.c localc;
      return;
    }
    Object localObject1 = awyu.a.hI();
    paramVarArgs = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new awyw.c(null);
      ((awyw.c)localObject3).mMessage = ((CharSequence)localObject2);
      paramVarArgs.add(localObject3);
    }
    this.d.oB(paramVarArgs);
  }
  
  public static class a
    extends RecyclerView.Adapter<awyw.b>
  {
    private Context mContext;
    private List<awyw.c> mInfoList;
    
    public a(@NonNull Context paramContext)
    {
      this.mContext = paramContext;
      this.mInfoList = new LinkedList();
    }
    
    public awyw.b a(ViewGroup paramViewGroup, int paramInt)
    {
      return new awyw.b(LayoutInflater.from(this.mContext).inflate(2131558553, paramViewGroup, false));
    }
    
    public void a(awyw.b paramb, int paramInt)
    {
      paramb.a((awyw.c)this.mInfoList.get(paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
    }
    
    public int getItemCount()
    {
      return this.mInfoList.size();
    }
    
    public void oB(@NonNull List<awyw.c> paramList)
    {
      this.mInfoList = paramList;
      ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.DashboardAdapter.1(this));
    }
  }
  
  static class b
    extends RecyclerView.ViewHolder
  {
    private TextView agV;
    
    public b(View paramView)
    {
      super();
      this.agV = ((TextView)paramView.findViewById(2131362280));
    }
    
    public void a(@NonNull awyw.c paramc)
    {
      this.agV.setText(paramc.mMessage);
    }
  }
  
  static class c
  {
    public CharSequence mMessage;
  }
  
  public static abstract interface d
  {
    public abstract void S(@NonNull List<awyu.b> paramList, @NonNull List<awyu.a> paramList1);
  }
  
  static class e
  {
    static CharSequence a(@NonNull awyu.b paramb)
    {
      if (paramb.Zp) {
        return paramb.toString();
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      paramb = paramb.toString();
      SpannableString localSpannableString = new SpannableString(paramb);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, paramb.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    
    static CharSequence a(@NonNull awyu.c paramc)
    {
      if ("failed".equals(paramc.jI))
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        paramc = paramc.toString();
        SpannableString localSpannableString = new SpannableString(paramc);
        localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, paramc.length(), 17);
        localSpannableStringBuilder.append(localSpannableString);
        return localSpannableStringBuilder;
      }
      return paramc.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awyw
 * JD-Core Version:    0.7.0.1
 */