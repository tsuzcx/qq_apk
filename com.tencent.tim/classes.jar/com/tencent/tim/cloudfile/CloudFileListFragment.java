package com.tencent.tim.cloudfile;

import aaja;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqha;
import aqhs;
import aqju;
import atcm;
import atdt;
import atdt.a;
import ateh;
import atfn;
import atfo;
import atfp;
import atfq;
import atfr;
import atfs;
import atft;
import atfu;
import atfv;
import atfw;
import atfx;
import atfy;
import atfz;
import atga;
import atgb;
import atgc;
import atgd;
import athu;
import atie;
import atik;
import atik.a;
import atin;
import atiu;
import ativ;
import atiz;
import atjx;
import atlo;
import atso;
import atwb;
import auds;
import aueh;
import augx;
import auhh;
import auhk;
import auhk.g;
import auib;
import aulh;
import aull;
import aulm;
import ault;
import aurf;
import auuw.b;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.fragment.FullScreenFragment;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.widget.PullRefreshHeader;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class CloudFileListFragment
  extends FullScreenFragment
  implements Handler.Callback, View.OnClickListener, augx, auhk, auhk.g
{
  private ArrayList<FileInfo> DU;
  private List<atiu> Kq = new ArrayList();
  public TextView MZ;
  private atcm jdField_a_of_type_Atcm;
  atgd jdField_a_of_type_Atgd = new atfs(this);
  atik.a jdField_a_of_type_Atik$a = new atft(this);
  private ativ jdField_a_of_type_Ativ;
  private atjx jdField_a_of_type_Atjx;
  private atlo jdField_a_of_type_Atlo;
  private auhh jdField_a_of_type_Auhh;
  private auib jdField_a_of_type_Auib;
  private auuw.b jdField_a_of_type_Auuw$b = new atfo(this);
  private CloudFileUploadingStatusBar jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar;
  private CloudSendBottomBar jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar;
  private TextView aeH;
  private boolean atv;
  private aaja jdField_b_of_type_Aaja;
  private atdt jdField_b_of_type_Atdt;
  private atlo jdField_b_of_type_Atlo;
  aulm jdField_b_of_type_Aulm = new atfr(this);
  private PullRefreshHeader jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader;
  private FPSSwipListView c;
  private byte[] cA;
  private String cGM;
  private String cGN;
  public TextView centerView;
  private boolean dhu;
  private boolean dhv;
  private boolean dhw;
  private boolean dhx;
  private boolean dhy;
  private int epA;
  private int epB;
  private int epC;
  private int epD;
  public RelativeLayout fD;
  private FileInfo g;
  RelativeLayout gu;
  private ImageView lW;
  public TextView leftView;
  private View mLoadingView;
  private View qi;
  private ImageView rightViewImg;
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private ImageView vq;
  private View xR;
  
  private int Om()
  {
    return ((aull)this.app.getManager(372)).OG();
  }
  
  private void Vw(boolean paramBoolean)
  {
    this.dhx = paramBoolean;
    if (paramBoolean)
    {
      this.rightViewImg.setVisibility(8);
      this.MZ.setVisibility(0);
      this.MZ.setText(2131721058);
      this.leftView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.leftView.setText(getString(2131691565));
      setTitle("已选1项");
      this.c.setDragEnable(false);
      this.jdField_b_of_type_Atdt.Vq(true);
      this.xR.setVisibility(0);
      this.lW.setEnabled(false);
      this.vq.setEnabled(false);
      this.aeH.setEnabled(false);
      this.centerView.setOnClickListener(null);
      return;
    }
    this.rightViewImg.setVisibility(0);
    this.MZ.setVisibility(8);
    this.rightViewImg.setImageResource(2130840650);
    this.leftView.setText("");
    setTitle(this.cGM);
    this.c.setDragEnable(true);
    this.jdField_b_of_type_Atdt.Vq(false);
    atiz.clearSelected();
    this.xR.setVisibility(8);
    this.centerView.setOnClickListener(this);
  }
  
  private boolean aJd()
  {
    return Arrays.equals(((atgc)this.app.getManager(373)).aE(), this.cA);
  }
  
  private void ckE()
  {
    this.mLoadingView.setVisibility(8);
    this.c.setVisibility(0);
    List localList = this.jdField_a_of_type_Auib.hk();
    this.Kq = localList;
    nB(localList);
    nA(localList);
    this.jdField_b_of_type_Atdt.mx(localList);
    if (this.jdField_b_of_type_Aaja != null)
    {
      if ((localList != null) && (localList.size() != 0)) {
        break label105;
      }
      this.jdField_b_of_type_Aaja.setShow(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ativ != null)
      {
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        this.jdField_a_of_type_Ativ.setVisible(false);
      }
      return;
      label105:
      this.jdField_b_of_type_Aaja.setShow(true);
    }
    this.jdField_a_of_type_Ativ.setVisible(true);
  }
  
  private void etp()
  {
    Object localObject = new atfv(this);
    atfw localatfw = new atfw(this);
    atfx localatfx = new atfx(this);
    atfy localatfy = new atfy(this);
    switch (this.epA)
    {
    }
    for (;;)
    {
      localObject = new atga(this);
      this.jdField_b_of_type_Atdt.a((atdt.a)localObject);
      this.leftView.setOnClickListener(new atgb(this));
      return;
      this.jdField_b_of_type_Atdt.setOnClickListener((View.OnClickListener)localObject);
      this.MZ.setOnClickListener(localatfw);
      continue;
      this.jdField_b_of_type_Atdt.setOnClickListener((View.OnClickListener)localObject);
      this.jdField_b_of_type_Atdt.setOnLongClickListener(new atfz(this));
      this.centerView.setOnClickListener(this);
      this.rightViewImg.setOnClickListener(localatfx);
      this.MZ.setOnClickListener(localatfy);
    }
  }
  
  private void iN(View paramView)
  {
    this.xR = paramView.findViewById(2131366191);
    this.xR.setVisibility(8);
    this.lW = ((ImageView)paramView.findViewById(2131366197));
    this.vq = ((ImageView)paramView.findViewById(2131366194));
    this.aeH = ((TextView)paramView.findViewById(2131366199));
    this.aeH.setVisibility(0);
    this.lW.setOnClickListener(this);
    this.vq.setOnClickListener(this);
    this.aeH.setOnClickListener(this);
  }
  
  private void initData()
  {
    this.g = ((FileInfo)getArguments().getParcelable("key_file_info"));
    this.dhw = getArguments().getBoolean("key_top_level_dir");
    if (this.g != null)
    {
      this.cA = this.g.Y();
      this.cGM = this.g.getName();
    }
    this.cGN = getArguments().getString("key_parent_dir_name");
    this.epA = getArguments().getInt("key_file_browser_mode", 0);
    this.epB = getArguments().getInt("key_bottom_bar_right_action", 0);
    this.epC = getArguments().getInt("key_bottom_bar_left_action", 2);
    this.DU = getArguments().getParcelableArrayList("key_file_to_be_dealt_with");
    this.epD = getArguments().getInt("key_bottom_bar_right_action", 4);
    if (this.epA == 2)
    {
      atiz.YO(getArguments().getString("targetUin"));
      atiz.YP(getArguments().getString("srcDiscGroup"));
      atiz.aav(getArguments().getInt("peerType", 0));
    }
  }
  
  private long is()
  {
    aull localaull = (aull)this.app.getManager(372);
    long l = localaull.iC();
    if (l != 0L) {
      return l;
    }
    if (localaull.OI() == 0) {
      ((aulh)this.app.getBusinessHandler(178)).VT(false);
    }
    return 0L;
  }
  
  private void nA(List<atiu> paramList)
  {
    if (this.epA == 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if ((localObject instanceof FileManagerEntity))
        {
          paramList.remove();
        }
        else if (((localObject instanceof atin)) && (this.DU != null))
        {
          Iterator localIterator = this.DU.iterator();
          while (localIterator.hasNext()) {
            if (Arrays.equals(((FileInfo)localIterator.next()).Y(), ((atin)localObject).Y())) {
              ((atin)localObject).setmClickable(false);
            }
          }
        }
      }
    }
  }
  
  private void nB(List<atiu> paramList)
  {
    int i = 0;
    Object localObject1 = (atgc)this.app.getManager(373);
    Object localObject5;
    Object localObject6;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int j;
    if ((Arrays.equals(this.cA, ((atgc)localObject1).aE())) && (this.jdField_a_of_type_Auib.hk() != null))
    {
      byte[] arrayOfByte1 = ((atgc)localObject1).aF();
      byte[] arrayOfByte2 = ((atgc)localObject1).aG();
      localObject5 = null;
      localObject1 = null;
      localObject6 = null;
      localObject2 = null;
      localObject3 = localObject6;
      localObject4 = localObject5;
      if (arrayOfByte1 != null)
      {
        localObject3 = localObject6;
        localObject4 = localObject5;
        if (arrayOfByte2 != null)
        {
          localObject6 = paramList.iterator();
          for (;;)
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localObject4 = ((Iterator)localObject6).next();
            localObject5 = localObject2;
            localObject3 = localObject1;
            if ((localObject4 instanceof atin))
            {
              localObject4 = (atin)localObject4;
              if (Arrays.equals(arrayOfByte1, ((atin)localObject4).Y()))
              {
                ((Iterator)localObject6).remove();
                localObject1 = localObject4;
              }
              if (Arrays.equals(arrayOfByte2, ((atin)localObject4).Y()))
              {
                ((Iterator)localObject6).remove();
                localObject2 = localObject4;
              }
              if (((atin)localObject4).name.equals(getString(2131691583))) {
                ((Iterator)localObject6).remove();
              }
              if (((atin)localObject4).name.equals(getString(2131691584))) {
                ((Iterator)localObject6).remove();
              }
              localObject5 = localObject2;
              localObject3 = localObject1;
              if (((atin)localObject4).name.equals(getString(2131691585)))
              {
                ((Iterator)localObject6).remove();
                localObject3 = localObject1;
                localObject5 = localObject2;
              }
            }
            localObject1 = localObject3;
            localObject2 = localObject5;
          }
        }
      }
      localObject1 = new atin(getString(2131691583), false);
      localObject2 = new atin(getString(2131691584), false);
      localObject5 = new atin(getString(2131691585), false);
      localObject6 = new atin(getString(2131693551), false);
      ((atin)localObject2).setTotalCount(Om());
      ((atin)localObject2).nm(is());
      if (this.epA == 1)
      {
        if (localObject4 != null) {
          ((atin)localObject4).setmClickable(false);
        }
        if (localObject3 != null) {
          localObject3.setmClickable(false);
        }
        ((atin)localObject2).setmClickable(false);
        ((atin)localObject5).setmClickable(false);
        ((atin)localObject1).setmClickable(false);
        ((atin)localObject6).setmClickable(false);
      }
      if (localObject1 != null)
      {
        paramList.add(0, localObject1);
        i = 1;
      }
      if (localObject5 == null) {
        break label599;
      }
      j = i + 1;
      paramList.add(i, localObject5);
      i = j;
    }
    label599:
    for (;;)
    {
      if (localObject6 != null)
      {
        j = i + 1;
        paramList.add(i, localObject6);
        ((atin)localObject6).aat(12);
        i = j;
      }
      for (;;)
      {
        if (localObject4 != null)
        {
          j = i + 1;
          paramList.add(i, localObject4);
          i = j;
        }
        for (;;)
        {
          int k = atiz.Ov();
          if ((k != 0) && (k != 3000))
          {
            j = i;
            if (k != 1) {}
          }
          else
          {
            paramList.add(i, localObject2);
            j = i + 1;
          }
          if (localObject3 != null) {
            paramList.add(j, localObject3);
          }
          ((atin)localObject1).aat(11);
          ((atin)localObject5).aat(8);
          return;
        }
      }
    }
  }
  
  private void updateUI()
  {
    if (this.dhv)
    {
      this.mLoadingView.setVisibility(0);
      this.c.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.cG(true, false);
    }
    ckE();
  }
  
  public boolean Pp()
  {
    return isResumed();
  }
  
  public void aam(int paramInt)
  {
    int i = 4;
    String str = "";
    Object localObject = "?pdid=" + aqhs.bytes2HexStr(this.cA);
    if (paramInt == 4)
    {
      str = "https://docs.qq.com/mall/m/index/doc?padtype=0&_wv=2&_wwv=512" + (String)localObject;
      if (paramInt != 4) {
        break label231;
      }
      i = 1;
    }
    for (;;)
    {
      ault.bE(str, "s_tim_myfile_menu_create");
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", str);
      ((Bundle)localObject).putString("title", getString(2131720937));
      ((Bundle)localObject).putInt("key_team_work_edit_type", i);
      ((Bundle)localObject).putString("tdsourcetag", "s_tim_cloud_new");
      TeamWorkDocEditBrowserActivity.a(getActivity(), (Bundle)localObject, true);
      return;
      if (paramInt == 5)
      {
        str = "https://docs.qq.com/mall/m/index/sheet?padtype=1&_wv=2&_wwv=512" + (String)localObject;
        break;
      }
      if (paramInt == 6)
      {
        str = "https://docs.qq.com/mall/m/index/form/collect?padtype=2&_wv=2&_wwv=512" + (String)localObject;
        break;
      }
      if (paramInt != 7) {
        break;
      }
      str = "https://docs.qq.com/mall/m/index/slide?padtype=4&_wv=2&_wwv=512" + (String)localObject;
      break;
      label231:
      if (paramInt == 5) {
        i = 2;
      } else if (paramInt == 6) {
        i = 3;
      } else if (paramInt != 7) {
        i = 1;
      }
    }
  }
  
  public void f(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.cG(paramBoolean1, paramBoolean2);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (paramBoolean1) {}
      ckE();
      return;
      this.c.post(new CloudFileListFragment.13(this));
      continue;
      this.c.post(new CloudFileListFragment.14(this));
      continue;
      this.dhy = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label93:
    do
    {
      do
      {
        return true;
        if (this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader != null)
        {
          if (paramMessage.arg1 != 1) {
            break label93;
          }
          this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader.tT(0);
        }
        for (;;)
        {
          paramMessage = new Message();
          paramMessage.what = 112;
          this.uiHandler.sendMessageDelayed(paramMessage, 500L);
          return true;
          this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader.tT(1);
        }
      } while (this.c == null);
      this.c.springBackOverScrollHeaderView();
      return true;
      paramMessage = (ateh)this.app.getBusinessHandler(180);
    } while (paramMessage == null);
    paramMessage.a(this.cA, 8, null);
    return true;
  }
  
  protected void initUI(View paramView)
  {
    this.mLoadingView = paramView.findViewById(2131370943);
    this.mLoadingView.setVisibility(0);
    this.c = ((FPSSwipListView)paramView.findViewById(2131367058));
    this.c.setDivider(null);
    this.c.setDividerHeight(0);
    this.c.setOverscrollHeader(getResources().getDrawable(2130851105));
    this.gu = ((RelativeLayout)paramView.findViewById(2131377546));
    this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131563195, this.c, false));
    this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader.setBackgroundDrawable(getResources().getDrawable(2130851105));
    this.c.setOverScrollHeader(this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader);
    if (this.cA != null) {
      this.jdField_a_of_type_Ativ = new ativ(getActivity(), "sp_key_refresh_time_cloud_file" + this.cA.toString(), this.c, this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader, new atfn(this));
    }
    this.c.setOnScrollListener(new atfu(this));
    this.c.setOverScrollListener(this.jdField_a_of_type_Ativ);
    this.qi = paramView.findViewById(2131379791);
    int i;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i = getResources().getColor(2131167361);
      if ((getActivity() == null) || (!ImmersiveUtils.a(getActivity().getWindow(), true))) {
        break label1134;
      }
      i = getResources().getColor(2131167562);
    }
    label1134:
    for (;;)
    {
      ((ImmersiveTitleBar2)paramView.findViewById(2131378720)).setBackgroundColor(i);
      this.fD = ((RelativeLayout)paramView.findViewById(2131379791));
      this.rightViewImg = ((ImageView)paramView.findViewById(2131369594));
      this.MZ = ((TextView)paramView.findViewById(2131369612));
      this.leftView = ((TextView)paramView.findViewById(2131369579));
      this.centerView = ((TextView)paramView.findViewById(2131369627));
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar = ((CloudSendBottomBar)paramView.findViewById(2131377980));
      Object localObject = (atgc)this.app.getManager(373);
      boolean bool = Arrays.equals(this.cA, ((atgc)localObject).aG());
      ArrayList localArrayList = new ArrayList();
      if (bool)
      {
        localArrayList.add(atcm.e);
        this.jdField_a_of_type_Atcm = new atcm(getActivity(), localArrayList, this.jdField_a_of_type_Auuw$b);
        this.c.setDragEnable(true);
        switch (this.epA)
        {
        default: 
          this.jdField_b_of_type_Atdt = new atie(this.app, getActivity(), this.cA, this);
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Atdt.setMode(this.epA);
        if (((this.epA == 2) || (this.epA == 1)) && (aJd())) {
          this.jdField_b_of_type_Atdt.Vt(true);
        }
        this.c.setAdapter(this.jdField_b_of_type_Atdt);
        iN(paramView);
        return;
        localArrayList.add(atcm.a);
        localArrayList.add(atcm.b);
        localArrayList.add(atcm.d);
        localArrayList.add(atcm.h);
        localArrayList.add(atcm.e);
        localArrayList.add(atcm.f);
        localArrayList.add(atcm.j);
        break;
        this.jdField_b_of_type_Atdt = new atdt(this.app, getActivity(), this);
        this.jdField_b_of_type_Atdt.Vs(true);
        this.rightViewImg.setVisibility(8);
        this.MZ.setVisibility(0);
        this.MZ.setText(2131721058);
        if (this.DU != null) {
          this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setFilesToBeDealtWith(this.DU);
        }
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setDestinationFileInfo(this.g);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setLeftAction(this.epC);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setRootDirSelectable(Boolean.valueOf(getArguments().getBoolean("key_is_root_dir_selectable", true)));
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setRightAction(this.epB);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setVisibility(0);
        this.jdField_b_of_type_Atdt.Vq(false);
        this.c.setDragEnable(false);
        continue;
        this.jdField_b_of_type_Atdt = new atdt(this.app, getActivity(), this);
        if (Arrays.equals(this.cA, ((atgc)localObject).aG())) {}
        for (this.jdField_b_of_type_Aaja = new aaja(this.c, this.gu, this.qi, getActivity(), null, 34, this.cA);; this.jdField_b_of_type_Aaja = new aaja(this.c, this.gu, this.qi, getActivity(), null, 43, this.cA))
        {
          localObject = new CloudFileUploadingStatusBar(getActivity());
          this.jdField_b_of_type_Atlo = new atlo(getActivity(), this.cA, (CloudFileUploadingStatusBar)localObject);
          this.c.addHeaderView((View)localObject);
          this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar = ((CloudFileUploadingStatusBar)paramView.findViewById(2131381358));
          this.jdField_a_of_type_Atlo = new atlo(getActivity(), this.cA, this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar);
          this.rightViewImg.setVisibility(0);
          this.MZ.setVisibility(8);
          this.rightViewImg.setImageResource(2130840650);
          this.c.setDragEnable(true);
          break;
        }
        this.jdField_b_of_type_Atdt = new atdt(this.app, getActivity(), this);
        this.jdField_b_of_type_Atdt.Vs(true);
        this.rightViewImg.setVisibility(8);
        this.MZ.setVisibility(0);
        this.MZ.setText(2131721058);
        this.c.setDragEnable(false);
        this.jdField_b_of_type_Atdt.Vq(true);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setLeftAction(this.epC);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setRightAction(this.epB);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setVisibility(0);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    Object localObject2;
    if (paramInt2 == -1)
    {
      localObject1 = null;
      if (paramIntent == null) {
        break label835;
      }
      if ((this.epB == 6) && (paramIntent.getBooleanExtra("key_mail_attach_select_finish", false)))
      {
        getActivity().setResult(-1, paramIntent);
        getActivity().finish();
        return;
      }
      if (!paramIntent.hasExtra("key_file_to_be_dealt_with")) {
        break label829;
      }
      localObject2 = paramIntent.getParcelableArrayListExtra("key_file_to_be_dealt_with");
      label75:
      localObject3 = localObject2;
      if (paramIntent.hasExtra("key_selected_dir")) {
        localObject1 = (FileInfo)paramIntent.getParcelableExtra("key_selected_dir");
      }
    }
    label826:
    label829:
    label835:
    for (Object localObject3 = localObject2;; localObject3 = null)
    {
      if (this.jdField_a_of_type_Auhh == null) {
        this.jdField_a_of_type_Auhh = ((auhh)this.jdField_a_of_type_Atjx.a(2));
      }
      switch (paramInt1)
      {
      case 1: 
      case 2: 
      case 8: 
      default: 
      case 9: 
      case 0: 
        for (;;)
        {
          label196:
          if ((paramInt1 == 1002) && (paramInt2 == 1122))
          {
            QQToast.a(getActivity(), 2, "权限设置成功", 0).show(getTitleBarHeight());
            localObject1 = paramIntent.getStringExtra("url");
            paramInt1 = paramIntent.getIntExtra("type", -1);
            if ((localObject1 == null) || (paramInt1 == -1) || (this.jdField_a_of_type_Auib == null)) {
              break;
            }
            this.jdField_a_of_type_Auib.gO((String)localObject1, paramInt1);
            return;
            if (this.epA == 1)
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("key_selected_dir", (Parcelable)localObject1);
              if (localObject3 != null) {
                ((Intent)localObject2).putParcelableArrayListExtra("key_file_to_be_dealt_with", (ArrayList)localObject3);
              }
              getActivity().setResult(-1, (Intent)localObject2);
              getActivity().finish();
              continue;
              if (paramIntent != null)
              {
                if (localObject1 != null) {
                  break label826;
                }
                localObject1 = this.g;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject3 == null) || (this.jdField_a_of_type_Auhh == null) || (localObject1 == null) || (((FileInfo)localObject1).Y() == null)) {
          break label196;
        }
        localObject2 = ((ArrayList)localObject3).iterator();
        Object localObject4;
        for (int i = 0; ((Iterator)localObject2).hasNext(); i = (int)(i + ((FileInfo)localObject4).getSize())) {
          localObject4 = (FileInfo)((Iterator)localObject2).next();
        }
        localObject2 = (atgc)this.app.getManager(373);
        if (i > ((atgc)localObject2).getTotalSpace() - ((atgc)localObject2).it())
        {
          athu.c(this.app, getActivity(), 2);
          break label196;
        }
        this.jdField_a_of_type_Auhh.a(((FileInfo)localObject1).Y(), (List)localObject3, 1, null);
        break label196;
        if ((localObject1 == null) || (atiz.Ou() <= 0)) {
          break label196;
        }
        localObject2 = atiz.eo().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if ((localObject3 instanceof PadInfo)) {
            ((ateh)this.app.getBusinessHandler(180)).a(((FileInfo)localObject1).Y(), athu.a((PadInfo)localObject3));
          } else if (((localObject3 instanceof FileManagerEntity)) && (this.jdField_a_of_type_Auhh != null) && (((FileInfo)localObject1).Y() != null)) {
            this.jdField_a_of_type_Auhh.a(((FileManagerEntity)localObject3).cloudFile.pLogicDirKey, aueh.a((FileManagerEntity)localObject3), ((FileInfo)localObject1).Y(), 4);
          }
        }
        atiz.clearSelected();
        break label196;
        localObject3 = atiz.eo();
        if ((localObject3 == null) || (this.jdField_a_of_type_Auhh == null) || (localObject1 == null) || (((FileInfo)localObject1).Y() == null)) {
          break label196;
        }
        localObject2 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if ((localObject4 instanceof FileManagerEntity)) {
            ((List)localObject2).add(aueh.a((FileManagerEntity)localObject4));
          } else if ((localObject4 instanceof atin)) {
            ((List)localObject2).add(aueh.a((atin)localObject4));
          }
        }
        this.jdField_a_of_type_Auhh.a(this.cA, (List)localObject2, ((FileInfo)localObject1).Y());
        Vw(false);
        break label196;
        localObject1 = paramIntent.getData();
        if (localObject1 == null) {
          break label196;
        }
        new atik(this.jdField_a_of_type_Atik$a).b((Uri)localObject1, getActivity());
        break label196;
        onBackPressed();
        break label196;
        break;
      }
      localObject2 = null;
      break label75;
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.dhx)
    {
      Vw(false);
      return true;
    }
    if (this.dhw)
    {
      atgc localatgc = (atgc)this.app.getManager(373);
      if ((this.epA == 2) && (this.g != null) && (Arrays.equals(this.g.Y(), localatgc.aE())))
      {
        atiz.clearSelected();
        atwb.clearSelected();
      }
      this.app.a().euy();
      getActivity().finish();
      return true;
    }
    return super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Auhh == null) {
      this.jdField_a_of_type_Auhh = ((auhh)this.jdField_a_of_type_Atjx.a(2));
    }
    Object localObject1;
    Object localObject2;
    atfp localatfp;
    atfq localatfq;
    switch (paramView.getId())
    {
    default: 
    case 2131369594: 
    case 2131369627: 
    case 2131366197: 
    case 2131366194: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Atcm != null)
          {
            this.jdField_a_of_type_Atcm.t(this.fD, this.fD.getWidth() - getResources().getDimensionPixelSize(2131299279), getResources().getDimensionPixelSize(2131299276));
            continue;
            localObject1 = (atgc)this.app.getManager(373);
            if ((this.g != null) && (!Arrays.equals(((atgc)localObject1).aG(), this.g.Y())))
            {
              this.jdField_a_of_type_Auhh.bH(athu.a(this.g));
              continue;
              localObject1 = atiz.el();
              ((List)localObject1).addAll(atiz.en());
              if (((List)localObject1).size() != 0)
              {
                localObject1 = new ArrayList((Collection)localObject1);
                this.jdField_a_of_type_Auhh.nS((List)localObject1);
                Vw(false);
              }
            }
          }
        }
        localObject2 = atiz.eo();
      } while (((List)localObject2).size() == 0);
      localatfp = new atfp(this, (List)localObject2);
      localatfq = new atfq(this);
      localObject1 = getString(2131691611);
      if (((List)localObject2).size() == 1)
      {
        localObject2 = (atiu)((List)localObject2).get(0);
        if (((atiu)localObject2).getCloudFileType() == 2) {
          localObject1 = getString(2131691612);
        }
      }
      break;
    }
    for (;;)
    {
      label334:
      aqha.a(getActivity(), 230, null, (String)localObject1, localatfp, localatfq).show();
      break;
      if (((atiu)localObject2).getCloudFileType() == 0)
      {
        localObject1 = getString(2131691611);
      }
      else if (((atiu)localObject2).getCloudFileType() == 1)
      {
        localObject1 = (atin)localObject2;
        int i = ((atin)localObject1).subDirCount + ((atin)localObject1).subFileCount;
        if (i > 0)
        {
          localObject1 = getString(2131691609, new Object[] { ((atin)localObject1).name, Integer.valueOf(i) });
        }
        else
        {
          localObject1 = getString(2131691610, new Object[] { ((atin)localObject1).name });
          continue;
          localObject1 = ((List)localObject2).iterator();
          i = 1;
          int j = 0;
          int k = 0;
          label484:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (!(localObject2 instanceof atin)) {
              break label666;
            }
            atin localatin = (atin)localObject2;
            j = localatin.subDirCount;
            j = k + (localatin.subFileCount + j);
            k = 1;
          }
          for (;;)
          {
            if (((atiu)localObject2).getCloudFileType() != 2) {
              i = 0;
            }
            for (;;)
            {
              m = k;
              k = j;
              j = m;
              break label484;
              if (i != 0)
              {
                localObject1 = "是否删除所选文件？";
                break label334;
              }
              if (k > 0)
              {
                localObject1 = getString(2131691607, new Object[] { Integer.valueOf(k) });
                break label334;
              }
              if (j != 0)
              {
                localObject1 = getString(2131691608);
                break label334;
              }
              localObject1 = getString(2131691611);
              break label334;
              localObject1 = atiz.eo();
              if (((List)localObject1).size() == 0) {
                break;
              }
              this.jdField_a_of_type_Auhh.nT((List)localObject1);
              break;
            }
            label666:
            int m = k;
            k = j;
            j = m;
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    super.onCreate(paramBundle);
    initData();
    this.dhv = true;
    this.jdField_a_of_type_Atjx = new atjx(this.app, getActivity(), this);
    this.jdField_a_of_type_Auib = this.jdField_a_of_type_Atjx.a(this.cA, this);
    if ((this.epA == 2) || (this.epA == 1)) {
      this.jdField_a_of_type_Auib.VP(true);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558487, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Atcm != null) {
      this.jdField_a_of_type_Atcm.dismiss();
    }
    if (this.jdField_a_of_type_Atjx != null) {
      this.jdField_a_of_type_Atjx.onDestroy();
    }
    atgc localatgc = (atgc)this.app.getManager(373);
    if (((Arrays.equals(this.cA, localatgc.aE())) && (this.epA == 2)) || (this.dhx)) {
      atiz.clearSelected();
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
    this.app.removeObserver(this.jdField_b_of_type_Aulm);
    if (this.jdField_b_of_type_Atdt != null) {
      this.jdField_b_of_type_Atdt.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.destroy();
    }
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Atcm != null) {
      this.jdField_a_of_type_Atcm.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.doOnPause();
    }
    if (this.jdField_b_of_type_Atdt != null) {
      this.jdField_b_of_type_Atdt.onPause();
    }
    if (this.jdField_b_of_type_Atlo != null) {
      this.jdField_b_of_type_Atlo.onPause();
    }
    if (this.jdField_a_of_type_Atlo != null) {
      this.jdField_a_of_type_Atlo.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) && (this.epA == 2)) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.dmH();
    }
    ateh localateh = (ateh)this.app.getBusinessHandler(180);
    if (this.dhv)
    {
      localateh.a(this.cA, 0, null);
      this.atv = true;
      this.dhv = false;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Atdt != null) {
        this.jdField_b_of_type_Atdt.onResume();
      }
      if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.doOnResume();
      }
      if (this.jdField_b_of_type_Atlo != null) {
        this.jdField_b_of_type_Atlo.onResume();
      }
      if (this.jdField_a_of_type_Atlo != null) {
        this.jdField_a_of_type_Atlo.onResume();
      }
      return;
      if (this.jdField_a_of_type_Auib != null) {
        this.jdField_a_of_type_Auib.eva();
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initUI(paramView);
    etp();
    this.app.addObserver(this.jdField_a_of_type_Atgd);
    this.app.addObserver(this.jdField_b_of_type_Aulm);
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    setTitle(this.cGM);
    updateUI();
  }
  
  public void qw(String paramString)
  {
    auds.D(1, paramString, 0);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.centerView != null) {
      this.centerView.setText(paramCharSequence);
    }
  }
  
  public void showSuccessToast(String paramString)
  {
    auds.D(2, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileListFragment
 * JD-Core Version:    0.7.0.1
 */