package com.dataline.activities;

import acbn;
import acde;
import acdl;
import acfp;
import acio;
import acir;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqfe;
import aqfx;
import aqfy;
import asbc;
import cb;
import cc;
import co;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cp;
import dm;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import syw;
import tar;

public class PrinterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static String TAG = "dataline.PrinterActivity";
  private TextView F;
  private TextView G;
  private TextView H;
  public ScrollerRunnable a;
  private acde jdField_b_of_type_Acde;
  private acdl jdField_b_of_type_Acdl = new cc(this);
  private AsyncImageView jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView;
  private String bC = "";
  private String bF = "";
  private String bG = "";
  private long din;
  public ViewGroup e;
  private RelativeLayout l;
  public XListView mListView;
  private Button u;
  private Button z;
  
  private boolean M()
  {
    String str = aqfe.get(this, "hp_bind_tip_key");
    long l1;
    if (!TextUtils.isEmpty(str)) {
      l1 = Long.parseLong(str);
    }
    return System.currentTimeMillis() - l1 > 2592000L;
  }
  
  private void bW()
  {
    if (this.l != null)
    {
      this.e.removeView(this.l);
      aqfe.J(this, "hp_bind_tip_key", String.valueOf(System.currentTimeMillis()));
    }
  }
  
  private void l(Object paramObject)
  {
    if (this.l == null)
    {
      LayoutInflater.from(this).inflate(2131559194, this.e, true);
      this.l = ((RelativeLayout)this.e.findViewById(2131363492));
      this.F = ((TextView)this.e.findViewById(2131363493));
      this.G = ((TextView)this.e.findViewById(2131363490));
      this.H = ((TextView)this.e.findViewById(2131363491));
      this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)this.e.findViewById(2131367022));
      Drawable localDrawable = super.getResources().getDrawable(2130840696);
      this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawable(localDrawable);
    }
    paramObject = (Object[])paramObject;
    this.din = ((Long)paramObject[0]).longValue();
    this.bC = ((String)paramObject[1]);
    this.bF = ((String)paramObject[2]);
    this.bG = ((String)paramObject[3]);
    if (this.l != null) {
      this.l.setOnClickListener(this);
    }
    tar.a();
    tar.a(this.app, this.din, "printer_hp", 1, 0, 0);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (paramInt1 == 56) {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("sFilesSelected");
        localObject1 = new Intent(this, PrinterOptionActivity.class);
        ((Intent)localObject1).setClass(this, PrinterOptionActivity.class);
        ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", paramIntent);
        ((Intent)localObject1).putExtra(aqfx.REQUEST_CODE, paramInt1);
        super.startActivityForResult((Intent)localObject1, 102);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt1 != 102) || (paramInt2 != -1));
      localObject1 = paramIntent.getParcelableArrayListExtra("sFilesSelected");
    } while (localObject1 == null);
    Object localObject2 = paramIntent.getStringExtra("sPrintParam");
    paramIntent.getLongExtra("sPrintDin", 0L);
    paramIntent.getStringExtra("sPrinterName");
    Object localObject3 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
    } while (!new VFSFile(((FileInfo)((Iterator)localObject3).next()).getPath()).exists());
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        LiteActivity.s(this);
        return;
      }
      localObject3 = this.jdField_b_of_type_Acde.b.a;
      if (localObject3 == null) {
        break;
      }
      boolean bool = ((co)localObject3).a((List)localObject1, (String)localObject2, this.app);
      label396:
      if (((co)localObject3).dB == 2)
      {
        if (bool)
        {
          Object localObject4 = cp.a(this.app, ((co)localObject3).ai);
          if (localObject4 != null)
          {
            localObject2 = (syw)this.app.getBusinessHandler(51);
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("din", ((DeviceInfo)localObject4).din + "");
            localObject4 = ((syw)localObject2).a(((DeviceInfo)localObject4).productId);
            if (localObject4 != null) {
              ((Bundle)localObject3).putString("devName", ((ProductInfo)localObject4).deviceName);
            }
            ((Bundle)localObject3).putBoolean("bFromLightApp", false);
            ((Bundle)localObject3).putInt("operType", 0);
            ((Bundle)localObject3).putInt("jumpTab", 0);
            ((syw)localObject2).bf((Bundle)localObject3);
          }
          finish();
        }
        label362:
        switch (paramIntent.getIntExtra(aqfx.REQUEST_CODE, 0))
        {
        default: 
          paramIntent = ((ArrayList)localObject1).iterator();
        }
      }
      while (paramIntent.hasNext())
      {
        localObject1 = (FileInfo)paramIntent.next();
        if (asbc.f(((FileInfo)localObject1).getName().toLowerCase(), new String[] { ".txt" }))
        {
          anot.a(this.app, "CliOper", "", "", "0X800401A", "0X800401A", 0, 0, "", "", "", "");
          continue;
          if ((((co)localObject3).dB != 1) || (!bool)) {
            break label362;
          }
          break label362;
          anot.a(this.app, "CliOper", "", "", "0X800405C", "0X800405C", 0, 0, "", "", "", "");
          break label396;
          anot.a(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
          break label396;
          anot.a(this.app, "CliOper", "", "", "0X800405B", "0X800405B", 0, 0, "", "", "", "");
          break label396;
        }
        if (asbc.f(((FileInfo)localObject1).getName().toLowerCase(), new String[] { ".doc", ".docx" })) {
          anot.a(this.app, "CliOper", "", "", "0X800401B", "0X800401B", 0, 0, "", "", "", "");
        } else if (asbc.f(((FileInfo)localObject1).getName().toLowerCase(), new String[] { ".ppt", ".pptx" })) {
          anot.a(this.app, "CliOper", "", "", "0X800401C", "0X800401C", 0, 0, "", "", "", "");
        } else if (asbc.f(((FileInfo)localObject1).getName().toLowerCase(), new String[] { ".xls", ".xlsx" })) {
          anot.a(this.app, "CliOper", "", "", "0X800401D", "0X800401D", 0, 0, "", "", "", "");
        } else if (asbc.f(((FileInfo)localObject1).getName().toLowerCase(), new String[] { ".jpg", ".png", ".jpeg", ".bmp" })) {
          anot.a(this.app, "CliOper", "", "", "0X800401E", "0X800401E", 0, 0, "", "", "", "");
        } else if (asbc.f(((FileInfo)localObject1).getName().toLowerCase(), new String[] { ".pdf" })) {
          anot.a(this.app, "CliOper", "", "", "0X800401F", "0X800401F", 0, 0, "", "", "", "");
        } else {
          anot.a(this.app, "CliOper", "", "", "0X8004020", "0X8004020", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165572);
    super.setContentView(2131559189);
    super.setTitle(2131692404);
    super.getWindow().setBackgroundDrawable(null);
    this.e = ((FrameLayout)super.findViewById(2131365595));
    this.e.setTag(2131361821, "n/a");
    this.u = ((Button)super.findViewById(2131379414));
    this.u.setOnClickListener(this);
    this.z = ((Button)super.findViewById(2131379415));
    this.z.setOnClickListener(this);
    this.jdField_b_of_type_Acde = ((acde)this.app.getBusinessHandler(8));
    this.jdField_b_of_type_Acde.a.b = new dm(this, this.jdField_b_of_type_Acde);
    this.mListView = ((XListView)super.findViewById(2131370596));
    this.a = new ScrollerRunnable(this.mListView);
    this.mListView.setAdapter(this.jdField_b_of_type_Acde.a.b);
    paramBundle = LayoutInflater.from(this).inflate(2131559032, null);
    this.mListView.setOverscrollHeader(super.getResources().getDrawable(2130845711));
    this.mListView.setOverScrollHeader(paramBundle);
    this.mListView.setOverScrollListener(new cb(this));
    this.app.addObserver(this.jdField_b_of_type_Acdl);
    paramBundle = (acir)this.app.getBusinessHandler(74);
    if (M()) {
      paramBundle.cKY();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_b_of_type_Acde.a.b = null;
    this.jdField_b_of_type_Acde.a.AE();
    if (this.a != null) {
      this.a.stop();
    }
    this.app.removeObserver(this.jdField_b_of_type_Acdl);
    if (this.l != null) {
      this.e.removeView(this.l);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.e);
    this.jdField_b_of_type_Acde.a.b.notifyDataSetChanged();
    LiteActivity.a(this.a, this.mListView);
    LiteActivity.a(this.mListView);
    Object localObject1 = super.getIntent();
    int i = ((Intent)localObject1).getIntExtra(aqfx.REQUEST_CODE, -1);
    if ((55 == i) || (i == 57))
    {
      ((Intent)localObject1).removeExtra(aqfx.REQUEST_CODE);
      Object localObject2 = ((Intent)localObject1).getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        try
        {
          ((ArrayList)localObject1).add(new FileInfo(str));
        }
        catch (FileNotFoundException localFileNotFoundException) {}
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = new Intent(this, PrinterOptionActivity.class);
        ((Intent)localObject2).putExtra(aqfx.REQUEST_CODE, i);
        ((Intent)localObject2).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject1);
        startActivityForResult((Intent)localObject2, 102);
      }
    }
    else
    {
      return;
    }
    LiteActivity.s(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131379414)
    {
      localIntent = new Intent(super.getApplicationContext(), FMLocalFileActivity.class);
      localIntent.putExtra("category", 6);
      localIntent.putExtra("busiType", 5);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", acbn.bky);
      localIntent.putExtra("peerType", 6001);
      localIntent.putExtra("STRING_Show_Music_Category", false);
      localIntent.putExtra("STRING_Show_Video_Category", false);
      localIntent.putExtra("STRING_Show_Apk_Category", false);
      localIntent.putExtra("STRING_Show_Pic_Category", false);
      localIntent.putExtra("STRING_SingleSelect", true);
      localIntent.putExtra(aqfx.REQUEST_CODE, 56);
      localIntent.putExtra("STRING_Show_Within_Suffixs", this.jdField_b_of_type_Acde.a.K());
      super.startActivityForResult(localIntent, 56);
      aqfy.anim(this, false, true);
      anot.a(this.app, "CliOper", "", "", "0X8004018", "0X8004018", 0, 0, "", "", "", "");
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (i != 2131379415) {
          break;
        }
        localIntent = new Intent(this, NewPhotoListActivity.class);
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", PrinterActivity.class.getName());
        localIntent.putExtra("busiType", 5);
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
        localIntent.putExtra(aqfx.REQUEST_CODE, 57);
        localIntent.putExtra("uin", acbn.bky);
        localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
        localIntent.getExtras().remove("forward_type");
        localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        localIntent.putExtra("STRING_Show_Within_Suffixs", this.jdField_b_of_type_Acde.a.K());
        super.startActivity(localIntent);
        aqfy.anim(this, false, true);
        anot.a(this.app, "CliOper", "", "", "0X8004019", "0X8004019", 0, 0, "", "", "", "");
      }
    } while (i != 2131363492);
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(this.bF))
    {
      localIntent.setClass(this, QQBrowserActivity.class);
      localIntent.putExtra("url", this.bG);
      localIntent.putExtra("title", acfp.m(2131709885));
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("selfSet_leftViewText", acfp.m(2131709886));
      localIntent.putExtra("leftViewText", acfp.m(2131709887));
      tar.a();
      tar.a(this.app, this.din, "printer_hp", 3, 0, 0);
    }
    for (;;)
    {
      a(this, localIntent);
      bW();
      tar.a();
      tar.a(this.app, this.din, "printer_hp", 2, 0, 0);
      break;
      localIntent.setClass(this, PrinterBindTipActivity.class);
      localIntent.putExtra("printer_bind_url", this.bF);
      localIntent.putExtra("din", this.din);
      tar.a();
      tar.a(this.app, this.din, "printer_hp", 4, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterActivity
 * JD-Core Version:    0.7.0.1
 */