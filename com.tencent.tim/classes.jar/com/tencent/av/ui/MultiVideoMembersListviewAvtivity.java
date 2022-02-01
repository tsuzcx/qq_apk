package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import iid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import jbv;
import jbw;
import jbx;
import jby;
import mqq.app.BaseActivity;

public class MultiVideoMembersListviewAvtivity
  extends BaseActivity
{
  public String Ry = null;
  public boolean Xp = false;
  public VideoController a;
  public a a;
  iid b = new jby(this);
  View.OnClickListener cc = new jbx(this);
  public ArrayList<VideoController.b> iM = null;
  public VideoAppInterface mApp = null;
  LayoutInflater mInflater = null;
  TextView mLeftBtn = null;
  ListView mListView = null;
  AdapterView.OnItemClickListener mOnItemClickListener = null;
  TextView mR = null;
  public int mUinType = -1;
  public long oE = 0L;
  
  public MultiVideoMembersListviewAvtivity()
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity$a = null;
  }
  
  public void Af()
  {
    String str = String.format(super.getResources().getString(2131697716), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.aN().size()) });
    if (this.mR != null) {
      this.mR.setText(str);
    }
  }
  
  void aqX()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "can not get intent");
      }
    }
    do
    {
      do
      {
        return;
        this.Ry = localIntent.getStringExtra("RelationUin");
        if (this.Ry != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoMembersListviewAvtivity", 2, "processExtraData-->can not get relationuin from intent");
      return;
      this.oE = Long.valueOf(this.Ry).longValue();
      this.mUinType = localIntent.getIntExtra("uinType", -1);
    } while ((this.mUinType != -1) || (!QLog.isColorLevel()));
    QLog.e("MultiVideoMembersListviewAvtivity", 2, "processExtraData-->can not get uintype from intent");
  }
  
  public void finishActivity()
  {
    super.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.Xp = super.getIntent().getBooleanExtra("KEY_ISFORGVIDEO", false);
    if (this.Xp) {
      super.setContentView(2131559919);
    }
    for (;;)
    {
      this.mApp = ((VideoAppInterface)super.getAppRuntime());
      if (this.mApp != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "onCreate-->can not get the VideoAppInterface");
      }
      super.finish();
      return;
      super.setContentView(2131559932);
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "onCreate-->can not get the VideoController");
      }
      super.finish();
      return;
    }
    this.mInflater = LayoutInflater.from(super.getApplicationContext());
    aqX();
    this.mApp.addObserver(this.b);
    this.mLeftBtn = ((TextView)super.findViewById(2131370358));
    this.mR = ((TextView)super.findViewById(2131371318));
    this.mLeftBtn.setOnClickListener(this.cc);
    this.mListView = ((ListView)super.findViewById(2131371241));
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity$a = new a();
    if (super.getIntent().getIntExtra("needDataSimple", 0) == 1) {}
    for (paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.aP();; paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.aN())
    {
      this.iM = new ArrayList();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        VideoController.b localb = (VideoController.b)paramBundle.next();
        this.iM.add(localb);
      }
    }
    if (this.Xp) {
      Collections.sort(this.iM, new jbv(this));
    }
    this.mListView.setAdapter(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity$a);
    paramBundle = String.format(super.getResources().getString(2131697716), new Object[] { Integer.valueOf(this.iM.size()) });
    this.mR.setText(paramBundle);
    this.mOnItemClickListener = new jbw(this);
    this.mListView.setOnItemClickListener(this.mOnItemClickListener);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mApp.deleteObserver(this.b);
    this.mApp = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.mInflater = null;
    this.iM = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity$a = null;
    this.mListView = null;
    this.mOnItemClickListener = null;
    this.mLeftBtn = null;
    this.mR = null;
    this.cc = null;
    this.b = null;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public class a
    extends BaseAdapter
  {
    a() {}
    
    Bitmap L()
    {
      return ((BitmapDrawable)MultiVideoMembersListviewAvtivity.d(MultiVideoMembersListviewAvtivity.this).getDrawable(2130840645)).getBitmap();
    }
    
    void a(VideoController.b paramb, a parama)
    {
      if ((MultiVideoMembersListviewAvtivity.this.mApp == null) || (paramb == null) || (parama == null)) {
        return;
      }
      if (paramb.faceBitmap == null)
      {
        parama.gA.setImageBitmap(L());
        MultiVideoMembersListviewAvtivity.this.mApp.getHandler().post(new MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1(this, parama, paramb));
        return;
      }
      parama.gA.setImageBitmap(paramb.faceBitmap);
    }
    
    String dy(String paramString)
    {
      int i = -1;
      if (MultiVideoMembersListviewAvtivity.this.mUinType == 3000) {
        i = 1004;
      }
      for (;;)
      {
        return MultiVideoMembersListviewAvtivity.this.mApp.getDisplayName(i, paramString, String.valueOf(MultiVideoMembersListviewAvtivity.this.oE));
        if (MultiVideoMembersListviewAvtivity.this.mUinType == 1) {
          i = 1000;
        }
      }
    }
    
    public int getCount()
    {
      if (MultiVideoMembersListviewAvtivity.this.iM == null) {
        return 0;
      }
      return MultiVideoMembersListviewAvtivity.this.iM.size();
    }
    
    public Object getItem(int paramInt)
    {
      return MultiVideoMembersListviewAvtivity.this.iM.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      View localView;
      label130:
      VideoController.b localb;
      if (paramView == null) {
        if (MultiVideoMembersListviewAvtivity.this.Xp)
        {
          paramView = MultiVideoMembersListviewAvtivity.this.mInflater.inflate(2131559918, null);
          localObject = new a();
          ((a)localObject).gA = ((ImageView)paramView.findViewById(2131369463));
          ((a)localObject).mName = ((TextView)paramView.findViewById(2131369478));
          ((a)localObject).mVideoIcon = ((ImageView)paramView.findViewById(2131369542));
          ((a)localObject).mAudioIcon = ((ImageView)paramView.findViewById(2131369546));
          if (MultiVideoMembersListviewAvtivity.this.Xp) {
            ((a)localObject).mS = ((TextView)paramView.findViewById(2131369472));
          }
          paramView.setTag(localObject);
          localView = paramView;
          paramView = (View)localObject;
          localb = (VideoController.b)MultiVideoMembersListviewAvtivity.this.iM.get(paramInt);
          paramView.oF = localb.uin;
          a(localb, paramView);
          localb.name = dy(String.valueOf(localb.uin));
          if (localb.name != null) {
            break label405;
          }
          localObject = "";
          label191:
          localb.name = ((String)localObject);
          paramView.mName.setText(localb.name);
          if ((localb.alV <= 0) && (!localb.Ph) && (!localb.Pi)) {
            break label415;
          }
          paramView.mVideoIcon.setVisibility(0);
          label242:
          if (!localb.Pg) {
            break label427;
          }
          paramView.mAudioIcon.setVisibility(0);
          label258:
          if (MultiVideoMembersListviewAvtivity.this.Xp)
          {
            int i = localb.level;
            int j = localb.alW;
            if (i < 0) {
              break label505;
            }
            paramView.mS.setVisibility(0);
            paramView.mS.setText("Lv." + i);
            switch (j)
            {
            }
          }
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        paramView = MultiVideoMembersListviewAvtivity.this.mInflater.inflate(2131559926, null);
        break;
        localObject = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break label130;
        label405:
        localObject = localb.name;
        break label191;
        label415:
        paramView.mVideoIcon.setVisibility(8);
        break label242;
        label427:
        paramView.mAudioIcon.setVisibility(4);
        break label258;
        paramView.mS.setTextColor(MultiVideoMembersListviewAvtivity.a(MultiVideoMembersListviewAvtivity.this).getColor(2131166263));
        continue;
        paramView.mS.setTextColor(MultiVideoMembersListviewAvtivity.b(MultiVideoMembersListviewAvtivity.this).getColor(2131166264));
        continue;
        paramView.mS.setTextColor(MultiVideoMembersListviewAvtivity.c(MultiVideoMembersListviewAvtivity.this).getColor(2131166265));
        continue;
        label505:
        paramView.mS.setVisibility(4);
      }
    }
    
    Bitmap p(String paramString)
    {
      if (MultiVideoMembersListviewAvtivity.this.mApp == null) {
        return null;
      }
      int i = -1;
      if (MultiVideoMembersListviewAvtivity.this.mUinType == 3000) {
        i = 1004;
      }
      for (;;)
      {
        return MultiVideoMembersListviewAvtivity.this.mApp.a(i, paramString, String.valueOf(MultiVideoMembersListviewAvtivity.this.oE), true, false);
        if (MultiVideoMembersListviewAvtivity.this.mUinType == 1) {
          i = 1000;
        }
      }
    }
    
    class a
    {
      public ImageView gA;
      public ImageView mAudioIcon;
      public TextView mName;
      public TextView mS;
      public ImageView mVideoIcon;
      public long oF;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoMembersListviewAvtivity
 * JD-Core Version:    0.7.0.1
 */