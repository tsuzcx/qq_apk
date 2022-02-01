package com.tencent.biz.troop.file;

import abeg.a;
import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import apbr;
import apsf;
import apsv;
import arhz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import smj;
import smk;
import sml;
import smm;
import smn;
import smo;
import smp;
import smq;
import smq.a;
import smq.e;
import svx;
import wja;

public class MoveFileActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.c
{
  private TextView Ax;
  public long CV;
  private View Y;
  private apsf jdField_a_of_type_Apsf;
  private a jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity$a = new a(null);
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = ByteStringMicro.copyFromUtf8("");
  private smq.a jdField_a_of_type_Smq$a = new smp(this);
  private smq.e jdField_a_of_type_Smq$e = new sml(this);
  private String aEG;
  public String aEH;
  public boolean aMc = false;
  private Button aX;
  private int bxI = 15;
  private int bxJ;
  public int bxK = 0;
  private arhz g;
  private int mCheckedIndex = -1;
  private String mFileId;
  private String mFileName;
  private boolean mIsEnd;
  private XListView mListView;
  private int mStartIndex;
  private ArrayList<apbr> oi = new ArrayList();
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.tim", MoveFileActivity.class.getName());
    localIntent.putExtra("troop_uin", paramString1);
    paramContext = paramString2;
    if (paramString2 == null) {
      paramContext = "/";
    }
    localIntent.putExtra("folder_id", paramContext);
    localIntent.putExtra("file_id", paramString3);
    localIntent.putExtra("file_name", paramString4);
    return localIntent;
  }
  
  private boolean fl(int paramInt)
  {
    return (this.aEG.equals("/")) || (paramInt < this.oi.size() - 1);
  }
  
  private void init()
  {
    bzw();
  }
  
  public void ath()
  {
    try
    {
      if ((this.g != null) && (this.g.isShowing())) {
        this.g.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarActivity", 2, localException.toString());
    }
  }
  
  public void bzw()
  {
    smq.a(this.app, this.CV, this.bxJ, 0, this.bxI, 3, 1, "/", 1, 0L, this.mStartIndex, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Smq$e);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    Object localObject = paramBundle.getString("troop_uin");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      finish();
      return false;
    }
    this.CV = Long.valueOf((String)localObject).longValue();
    this.aEG = paramBundle.getString("folder_id");
    if (TextUtils.isEmpty(this.aEG))
    {
      finish();
      return false;
    }
    this.mFileName = paramBundle.getString("file_name");
    if (TextUtils.isEmpty(this.mFileName))
    {
      finish();
      return false;
    }
    this.mFileId = paramBundle.getString("file_id");
    if (TextUtils.isEmpty(this.mFileId))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_Apsf = apsf.a(this.app, this.CV);
    paramBundle = (LayoutInflater)getSystemService("layout_inflater");
    localObject = paramBundle.inflate(2131560794, null);
    this.mListView = ((XListView)((View)localObject).findViewById(2131365101));
    this.mListView.setVerticalScrollBarEnabled(false);
    this.mListView.setDivider(null);
    this.mListView.setFocusable(false);
    this.mListView.setOnItemClickListener(this);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131365517);
    this.aX = ((Button)((View)localObject).findViewById(2131365219));
    localTextView.setOnClickListener(this);
    this.aX.setOnClickListener(this);
    setContentView((View)localObject);
    setTitle(2131699820);
    localTextView = (TextView)findViewById(2131369612);
    localTextView.setText(2131721058);
    localTextView.setOnClickListener(this);
    localTextView.setVisibility(0);
    this.leftView.setVisibility(8);
    localObject = (TextView)((View)localObject).findViewById(2131367070);
    TextUtils.ellipsize(this.mFileName, ((TextView)localObject).getPaint(), wja.dp2px(230.0F, getResources()), TextUtils.TruncateAt.MIDDLE, false, new smj(this, (TextView)localObject));
    this.Y = paramBundle.inflate(2131560799, null);
    this.Y.findViewById(2131374460).setBackgroundResource(2130838900);
    this.mListView.addFooterView(this.Y);
    this.Y.setVisibility(8);
    this.Ax = ((TextView)this.Y.findViewById(2131374461));
    this.Ax.setTextColor(getResources().getColor(2131167304));
    this.mListView.setOnScrollListener(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity$a);
    this.mListView.setAdapter(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity$a);
    init();
    anot.a(this.app, "P_CliOper", "Grp_files", "", "file", "move_file", 0, 0, Long.toString(this.CV), "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.app, "P_CliOper", "Grp_files", "", "file", "move_cancel", 0, 0, Long.toString(this.CV), "", "", "");
      finish();
      overridePendingTransition(0, 2130772013);
      continue;
      if (apsv.a(this.app, this, this.CV) != 0)
      {
        r(getResources().getString(2131699754), null, this.aEH, "");
        continue;
        apbr localapbr = (apbr)this.oi.get(this.mCheckedIndex);
        if (this.aEG.equals(localapbr.mFileId))
        {
          finish();
          overridePendingTransition(0, 2130772013);
        }
        else
        {
          try
          {
            if (apsv.a(this.app, this, this.CV) != 0)
            {
              smq.a(this.app, this.CV, localapbr.dTg, this.mFileId, this.aEG, localapbr.mFileId, new smk(this, localapbr));
              yC(2131699821);
            }
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == this.mCheckedIndex) {
      return;
    }
    this.aX.setEnabled(true);
    this.aX.setBackgroundResource(2130839545);
    this.aX.setTextAppearance(getActivity(), 2131755587);
    this.mCheckedIndex = paramInt;
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity$a.notifyDataSetChanged();
  }
  
  public void r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = svx.a(this, paramString1, "", 2131721058, 2131691970, new smm(this), new smn(this));
    paramString2 = paramString1.getEditText();
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2.setText(paramString3);
    }
    paramString2.setFilters(new InputFilter[] { new InputFilter.LengthFilter(48) });
    paramString2.setHint(2131699830);
    paramString2.addTextChangedListener(new smo(this, paramString2, paramString1));
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.bH(paramString4, -65536);
    }
    paramString1.getBtnight().setEnabled(false);
    paramString1.getBtnight().setTextColor(getResources().getColor(2131165758));
    paramString1.show();
    new Handler(getMainLooper()).post(new MoveFileActivity.7(this, paramString2));
  }
  
  public void tG(boolean paramBoolean)
  {
    if (this.mListView.getFirstVisiblePosition() == 0)
    {
      this.Y.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      this.Y.setVisibility(8);
      return;
    }
    this.Y.setVisibility(0);
    this.Ax.setText(2131720482);
    Drawable localDrawable = getResources().getDrawable(2130839651);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.Ax.setCompoundDrawables(localDrawable, null, null, null);
    ((Animatable)localDrawable).start();
  }
  
  public void yC(int paramInt)
  {
    try
    {
      if (this.g == null) {
        this.g = new arhz(this, getTitleBarHeight());
      }
      this.g.setMessage(paramInt);
      this.g.setBackAndSearchFilter(false);
      this.g.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarActivity", 2, localException.toString());
    }
  }
  
  public class a
    extends BaseAdapter
    implements AbsListView.e
  {
    private int blU;
    private int mLastVisibleIndex;
    
    private a() {}
    
    public int getCount()
    {
      return MoveFileActivity.a(MoveFileActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return MoveFileActivity.a(MoveFileActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      MoveFileActivity.b localb;
      if (paramView == null)
      {
        paramView = MoveFileActivity.this.getLayoutInflater().inflate(2131560800, MoveFileActivity.a(MoveFileActivity.this), false);
        localb = new MoveFileActivity.b(null);
        localb.Az = ((TextView)paramView.findViewById(2131367370));
        localb.ov = ((ImageView)paramView.findViewById(2131367367));
        localb.AA = ((TextView)paramView.findViewById(2131364577));
        paramView.setTag(localb);
      }
      for (;;)
      {
        localb = (MoveFileActivity.b)paramView.getTag();
        apbr localapbr = (apbr)MoveFileActivity.a(MoveFileActivity.this).get(paramInt);
        if (localapbr != null)
        {
          if (!MoveFileActivity.a(MoveFileActivity.this, paramInt)) {
            break label183;
          }
          localb.Az.setText(localapbr.str_file_name);
          localb.ov.setImageResource(2130844531);
          if (paramInt != MoveFileActivity.a(MoveFileActivity.this)) {
            break label209;
          }
          localb.AA.setVisibility(0);
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          label183:
          localb.Az.setText(acfp.m(2131708472));
          localb.ov.setImageResource(2130844533);
          break;
          label209:
          localb.AA.setVisibility(4);
        }
      }
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      this.blU = paramInt3;
      this.mLastVisibleIndex = (paramInt1 + paramInt2 - 1 - 1);
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (paramInt == 0)
      {
        QLog.e("IphoneTitleBarActivity", 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
        if (this.mLastVisibleIndex == this.blU - 2)
        {
          if (!MoveFileActivity.a(MoveFileActivity.this)) {
            break label44;
          }
          MoveFileActivity.this.tG(true);
        }
      }
      label44:
      do
      {
        return;
        MoveFileActivity.this.tG(false);
      } while (apsv.a(MoveFileActivity.this.app, MoveFileActivity.this, MoveFileActivity.this.CV) == 0);
      MoveFileActivity.this.bzw();
    }
  }
  
  static class b
    extends abeg.a
  {
    public TextView AA;
    public TextView Az;
    public ImageView ov;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity
 * JD-Core Version:    0.7.0.1
 */