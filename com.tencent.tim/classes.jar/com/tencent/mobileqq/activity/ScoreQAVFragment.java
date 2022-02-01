package com.tencent.mobileqq.activity;

import acfp;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqmj;
import com.tencent.av.VideoConstants;
import com.tencent.av.widget.RatingBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import igd;
import igk;
import igl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import jjy;
import jkw;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import vsv;
import vsw;
import vsx;

public class ScoreQAVFragment
  extends PublicBaseFragment
{
  public long GQ;
  public long GR;
  public long GS = 1L;
  public long GT;
  private c a;
  public String aPM = "";
  String aPN = "";
  String aPO = "";
  String aPP = "";
  RatingBar b = null;
  View.OnClickListener du = new vsx(this);
  HashMap<Integer, Integer> gB = new HashMap();
  public TextView jk = null;
  public TextView kn = null;
  public QQAppInterface mApp;
  public long mBeginTime;
  public Button mCommitBtn = null;
  public List<String> mDatas;
  public long mEndTime;
  public ImageView mIcon;
  public String mIp;
  private RecyclerView mRecyclerView;
  public int mSdkVersion;
  public String mSelfUin;
  public String mToUin;
  public int mUinType;
  public ArrayList<Integer> px = new ArrayList();
  
  public void Bx(int paramInt)
  {
    int i = 0;
    while (i < this.px.size())
    {
      if (((Integer)this.px.get(i)).intValue() == paramInt) {
        this.px.remove(i);
      }
      i += 1;
    }
  }
  
  public void bVj()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    int i = 0;
    while (i < this.px.size())
    {
      localStringBuilder.append(this.gB.get(this.px.get(i)));
      localStringBuilder.append(';');
      i += 1;
    }
    this.aPM = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "enCodeString mReportProblems : " + this.aPM);
    }
  }
  
  boolean gm(int paramInt)
  {
    int i = 0;
    boolean bool = false;
    while (i < this.px.size())
    {
      if (((Integer)this.px.get(i)).intValue() == paramInt) {
        bool = true;
      }
      i += 1;
    }
    return bool;
  }
  
  void initUI(View paramView)
  {
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(2131376997));
    this.mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    this.b = ((RatingBar)paramView.findViewById(2131376629));
    this.mIcon = ((ImageView)paramView.findViewById(2131368698));
    try
    {
      if (jjy.cK("qav_score_normal.jpg")) {
        this.mIcon.setBackgroundDrawable(new BitmapDrawable(getResources(), jjy.ht() + "qav_score_normal.jpg"));
      }
      this.b.setOnRatingListener(new vsv(this));
      this.mCommitBtn = ((Button)paramView.findViewById(2131365059));
      this.mCommitBtn.setOnClickListener(this.du);
      this.mCommitBtn.setEnabled(false);
      this.mCommitBtn.setTextColor(Color.parseColor("#BBBBBB"));
      this.jk = ((TextView)paramView.findViewById(2131375378));
      this.kn = ((TextView)paramView.findViewById(2131379000));
      this.mApp = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.mApp != null) {
        this.mSelfUin = this.mApp.getCurrentAccountUin();
      }
      if (aqmj.i(this.mSelfUin).getBoolean(VideoConstants.Ml, false))
      {
        this.kn.setText(2131698059);
        this.b.setClickable(false);
      }
      this.a = new c();
      paramView = new vsw(this);
      this.a.a(paramView);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScoreActivity", 2, "mIcon OOM: " + localOutOfMemoryError);
        }
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559968, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    try
    {
      this.mUinType = paramBundle.getInt("uinType", 0);
      this.GT = paramBundle.getLong("uniseq", 0L);
      initUI(paramView);
      new b().execute(new String[0]);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  void parse(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      igd.aJ("ScoreActivity", "parse config: " + paramString);
    }
    do
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("scoreProblemsVideo")) {
          this.aPN = paramString.getString("scoreProblemsVideo");
        }
        if (paramString.has("scoreProblemsAudio")) {
          this.aPO = paramString.getString("scoreProblemsAudio");
        }
        if (paramString.has("scoreProblemsNet")) {
          this.aPP = paramString.getString("scoreProblemsNet");
        }
        return;
      }
      catch (Exception paramString)
      {
        do
        {
          paramString.printStackTrace();
          igd.aJ("ScoreActivity", "parse exception: " + paramString.toString());
        } while (!QLog.isColorLevel());
        return;
      }
      igd.aJ("ScoreActivity", "parse|config is empty!");
    } while (!QLog.isColorLevel());
  }
  
  void wv(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      igd.aJ("ScoreActivity", "parse infos: " + paramString);
    }
    do
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has(VideoConstants.Md)) {
          this.mBeginTime = paramString.getLong(VideoConstants.Md);
        }
        if (paramString.has(VideoConstants.Me)) {
          this.mEndTime = paramString.getLong(VideoConstants.Me);
        }
        if (paramString.has(VideoConstants.Mf)) {
          this.mSdkVersion = paramString.getInt(VideoConstants.Mf);
        }
        if (paramString.has(VideoConstants.Mj)) {
          this.GR = paramString.getLong(VideoConstants.Mj);
        }
        if (paramString.has(VideoConstants.Mi)) {
          this.GQ = paramString.getLong(VideoConstants.Mi);
        }
        if (paramString.has(VideoConstants.Mk)) {
          this.mToUin = paramString.getString(VideoConstants.Mk);
        }
        return;
      }
      catch (Exception paramString)
      {
        do
        {
          paramString.printStackTrace();
          igd.aJ("ScoreActivity", "parse exception: " + paramString.toString());
        } while (!QLog.isColorLevel());
        QLog.i("ScoreActivity", 2, "parse exception: " + paramString.toString());
        return;
      }
      igd.aJ("ScoreActivity", "parse|infos is empty!");
    } while (!QLog.isColorLevel());
    QLog.i("ScoreActivity", 2, "parse|infos is empty!");
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(View paramView, int paramInt);
  }
  
  class b
    extends AsyncTask<String, Void, HashMap<Integer, Integer>>
  {
    b() {}
    
    protected HashMap<Integer, Integer> a(String... paramVarArgs)
    {
      int i = 0;
      if ((ScoreQAVFragment.this.mSelfUin == null) || (ScoreQAVFragment.this.mSelfUin.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mSelfUin is null!");
        }
        return null;
      }
      paramVarArgs = aqmj.i(ScoreQAVFragment.this.mSelfUin);
      ScoreQAVFragment.this.mIp = paramVarArgs.getString(VideoConstants.Mh, "");
      paramVarArgs = jkw.hw();
      ScoreQAVFragment.this.wv(paramVarArgs);
      paramVarArgs = igl.b(270).content;
      ScoreQAVFragment.this.parse(paramVarArgs);
      if (ScoreQAVFragment.this.aPN.isEmpty())
      {
        ScoreQAVFragment.this.aPN = ScoreQAVFragment.this.mApp.getApplication().getString(2131698062);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Video config data is invalid, use default!");
        }
      }
      if (ScoreQAVFragment.this.aPO.isEmpty())
      {
        ScoreQAVFragment.this.aPO = ScoreQAVFragment.this.mApp.getApplication().getString(2131698060);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Audio config data is invalid, use default!");
        }
      }
      if (ScoreQAVFragment.this.aPP.isEmpty())
      {
        ScoreQAVFragment.this.aPP = ScoreQAVFragment.this.mApp.getApplication().getString(2131698061);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Net config data is invalid, use default!");
        }
      }
      if (ScoreQAVFragment.this.GR == 0L) {
        paramVarArgs = ScoreQAVFragment.this.aPN + "/" + ScoreQAVFragment.this.aPO + "/" + ScoreQAVFragment.this.aPP;
      }
      try
      {
        ScoreQAVFragment.this.mDatas = Arrays.asList(paramVarArgs.split("/"));
        if ((ScoreQAVFragment.this.mDatas != null) && (ScoreQAVFragment.this.mDatas.size() > 0))
        {
          i = 0;
          if (i >= ScoreQAVFragment.this.mDatas.size()) {
            break label778;
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        try
        {
          do
          {
            for (;;)
            {
              paramVarArgs = ((String)ScoreQAVFragment.this.mDatas.get(i)).split(",");
              ScoreQAVFragment.this.mDatas.set(i, paramVarArgs[1]);
              int j = Integer.parseInt(paramVarArgs[0]);
              ScoreQAVFragment.this.gB.put(Integer.valueOf(i), Integer.valueOf(j));
              i += 1;
              continue;
              paramVarArgs = ScoreQAVFragment.this.aPO + "/" + ScoreQAVFragment.this.aPP;
            }
            paramVarArgs = paramVarArgs;
            paramVarArgs.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.i("ScoreActivity", 2, "parse exception : " + paramVarArgs.getMessage());
        }
        catch (Exception paramVarArgs)
        {
          for (;;)
          {
            paramVarArgs.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("ScoreActivity", 2, "parse exception : " + paramVarArgs.getMessage());
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "processDataTask mDatas is invalid, use default!");
        }
        ScoreQAVFragment.this.mDatas = new ArrayList();
        ScoreQAVFragment.this.mDatas.add(acfp.m(2131714066));
        ScoreQAVFragment.this.mDatas.add(acfp.m(2131714059));
        ScoreQAVFragment.this.mDatas.add(acfp.m(2131714062));
        ScoreQAVFragment.this.mDatas.add(acfp.m(2131714065));
        ScoreQAVFragment.this.mDatas.add(acfp.m(2131714060));
        ScoreQAVFragment.this.mDatas.add(acfp.m(2131714064));
        ScoreQAVFragment.this.mDatas.add(acfp.m(2131714061));
        ScoreQAVFragment.this.mDatas.add(acfp.m(2131714063));
        while (i < ScoreQAVFragment.this.mDatas.size())
        {
          ScoreQAVFragment.this.gB.put(Integer.valueOf(i), Integer.valueOf(i));
          i += 1;
        }
      }
      label778:
      return ScoreQAVFragment.this.gB;
    }
    
    protected void x(HashMap<Integer, Integer> paramHashMap)
    {
      super.onPostExecute(paramHashMap);
    }
  }
  
  public class c
    extends RecyclerView.Adapter<a>
  {
    ScoreQAVFragment.a jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$a;
    
    c() {}
    
    public a a(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(ScoreQAVFragment.this.mApp.getApplication().getApplicationContext()).inflate(2131559967, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$a);
    }
    
    public void a(ScoreQAVFragment.a parama)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$a = parama;
    }
    
    public void a(a parama, int paramInt)
    {
      parama.dx.setText((CharSequence)ScoreQAVFragment.this.mDatas.get(paramInt));
      if (ScoreQAVFragment.this.gm(paramInt)) {
        parama.dx.setSelected(true);
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
        return;
        parama.dx.setSelected(false);
      }
    }
    
    public int getItemCount()
    {
      return ScoreQAVFragment.this.mDatas.size();
    }
    
    class a
      extends RecyclerView.ViewHolder
      implements View.OnClickListener
    {
      ScoreQAVFragment.a a;
      Button dx;
      
      public a(View paramView, ScoreQAVFragment.a parama)
      {
        super();
        this.a = parama;
        this.dx = ((Button)paramView.findViewById(2131375378));
        this.dx.setOnClickListener(this);
      }
      
      public void onClick(View paramView)
      {
        if (this.a != null) {
          this.a.onItemClick(paramView, getPosition());
        }
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ScoreActivity", 2, "mOnItemClickListener is null!");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment
 * JD-Core Version:    0.7.0.1
 */