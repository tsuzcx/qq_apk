package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerGalleryAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.Gallery;
import dtq;
import dtr;
import java.util.List;

public abstract class PhotoFileViewBase
  extends FileViewBase
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private FileViewerGalleryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter = new FileViewerGalleryAdapter(BaseApplicationImpl.getContext());
  public AdapterView.OnItemClickListener a;
  public AdapterView.OnItemSelectedListener a;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  private final String jdField_a_of_type_JavaLangString = "PhotoFileViewBase";
  private boolean jdField_a_of_type_Boolean = false;
  
  public PhotoFileViewBase(Activity paramActivity, List paramList, int paramInt)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new dtq(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new dtr(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.a(paramList);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("PhotoFileViewBase", 4, "initVarView: but adapter is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_a_of_type_AndroidViewView.findViewById(2131297187));
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131492924));
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903450, paramViewGroup, false);
    e();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public abstract PhotoFileViewBase.IControllProxyInterface a();
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getCount() > 1)
    {
      int i = this.jdField_a_of_type_Int;
      return i + 1 + "/" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getCount();
    }
    return BaseApplicationImpl.getContext().getString(2131361985);
  }
  
  public void a()
  {
    a().b();
  }
  
  public void a(IFileViewerAdapter paramIFileViewerAdapter, String paramString)
  {
    if (paramIFileViewerAdapter == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getItem(this.jdField_a_of_type_Int))
    {
      paramIFileViewerAdapter.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase
 * JD-Core Version:    0.7.0.1
 */