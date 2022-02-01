package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.Gallery;
import fss;
import fst;
import fsu;
import fsv;
import fsw;
import fsx;
import fsy;
import fsz;
import fta;

public class BaseFileViewerController
  implements IFileViewerController
{
  public View.OnClickListener a;
  public BaseFileViewerActivity a;
  BaseFileViewerController.ViewHoler a;
  public AdapterView.OnItemClickListener a;
  public AdapterView.OnItemSelectedListener a;
  public View.OnClickListener b = new fst(this);
  public View.OnClickListener c = new fsu(this);
  public View.OnClickListener d = new fsv(this);
  public View.OnClickListener e = new fsw(this);
  public View.OnClickListener f = new fsx(this);
  public View.OnClickListener g = new fsy(this);
  
  public BaseFileViewerController(BaseFileViewerActivity paramBaseFileViewerActivity)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fss(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new fsz(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new fta(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity = paramBaseFileViewerActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler = new BaseFileViewerController.ViewHoler(this);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131231447));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.c = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131231379));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131231460));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131231455));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131231375));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232362));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.g = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232363));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131231776));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232374));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131231519));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.e = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232376));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232377));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.d = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232375));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.f = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232784));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232365));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131231505));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.h = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232366));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232367));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.i = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232712));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.j = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232713));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.k = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232364));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.l = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232782));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.p = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232716));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.m = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232714));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.n = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232711));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.o = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.findViewById(2131232783));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.b);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838011);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558753));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558754));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.d.setOnClickListener(this.c);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.i.setOnClickListener(this.c);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.d);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.d);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.m.setOnClickListener(this.e);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.n.setOnClickListener(this.f);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.o.setOnClickListener(this.g);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.d.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.e.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.f.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.h.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.i.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.j.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.m.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.l.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.n.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.o.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.p.setVisibility(4);
  }
  
  public ViewerData a()
  {
    return null;
  }
  
  public void a()
  {
    c();
    Object localObject = a();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getClass().getSimpleName();
      QLog.e((String)localObject, 1, (String)localObject + ":refreshUI, but viewerdata is null");
    }
    for (;;)
    {
      return;
      if ((((ViewerData)localObject).m != null) && (((ViewerData)localObject).m.length() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130838595);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(((ViewerData)localObject).m);
        if (!((ViewerData)localObject).jdField_g_of_type_Boolean) {
          break label630;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.d();
        label108:
        if (!((ViewerData)localObject).jdField_c_of_type_Boolean) {
          break label640;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        if ((((ViewerData)localObject).jdField_b_of_type_JavaLangString != null) && (((ViewerData)localObject).jdField_b_of_type_JavaLangString.length() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetTextView.setText(((ViewerData)localObject).jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.g.setText(((ViewerData)localObject).jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.k.setText(((ViewerData)localObject).jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.p.setText(((ViewerData)localObject).l);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.e.setText(((ViewerData)localObject).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((ViewerData)localObject).jdField_a_of_type_Float * 100.0F));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.d.setText(((ViewerData)localObject).jdField_g_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.h.setText(((ViewerData)localObject).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetProgressBar.setProgress((int)(((ViewerData)localObject).jdField_a_of_type_Float * 100.0F));
        if (!((ViewerData)localObject).jdField_f_of_type_Boolean)
        {
          if (a(((ViewerData)localObject).i))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.n.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.n.setText(((ViewerData)localObject).i);
          }
          if (a(((ViewerData)localObject).j))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.o.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.o.setText(((ViewerData)localObject).j);
          }
          if (a(((ViewerData)localObject).k))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.m.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.m.setText(((ViewerData)localObject).k);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.m.setEnabled(((ViewerData)localObject).jdField_e_of_type_Boolean);
          }
          if (a(((ViewerData)localObject).jdField_g_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.d.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.d.setText(((ViewerData)localObject).jdField_g_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.i.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.i.setText(((ViewerData)localObject).jdField_g_of_type_JavaLangString);
          }
        }
        if (a(((ViewerData)localObject).jdField_f_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.j.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.j.setText(((ViewerData)localObject).jdField_f_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.f.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.f.setText(((ViewerData)localObject).jdField_f_of_type_JavaLangString);
        }
        if (a(((ViewerData)localObject).jdField_e_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.l.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.l.setText(((ViewerData)localObject).jdField_e_of_type_JavaLangString);
        }
        if ((FileManagerUtil.a(((ViewerData)localObject).jdField_c_of_type_JavaLangString) != 0) || (!((ViewerData)localObject).jdField_a_of_type_Boolean)) {
          break label755;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
        if (((ViewerData)localObject).jdField_d_of_type_Boolean) {
          break label654;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((ViewerData)localObject).jdField_c_of_type_JavaLangString);
        break;
        label630:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.e();
        break label108;
        label640:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      label654:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (((ViewerData)localObject).jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.e.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (((ViewerData)localObject).jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        return;
      }
      if (((ViewerData)localObject).h)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
        label755:
        if (((ViewerData)localObject).jdField_f_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.h.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if (!((ViewerData)localObject).jdField_b_of_type_Boolean) {
            break label836;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        }
        while (a(((ViewerData)localObject).l))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.p.setVisibility(0);
          return;
          label836:
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerController$ViewHoler.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
        }
      }
    }
  }
  
  public void a(View paramView) {}
  
  public void a(Object paramObject) {}
  
  public boolean a(Menu paramMenu)
  {
    return true;
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    return true;
  }
  
  boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0);
  }
  
  public void b(View paramView) {}
  
  public void c(View paramView) {}
  
  public void d(View paramView) {}
  
  public void e(View paramView) {}
  
  public void f(View paramView) {}
  
  public void g(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerController
 * JD-Core Version:    0.7.0.1
 */