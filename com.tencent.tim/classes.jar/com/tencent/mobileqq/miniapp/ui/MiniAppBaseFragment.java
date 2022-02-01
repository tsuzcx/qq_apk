package com.tencent.mobileqq.miniapp.ui;

import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public class MiniAppBaseFragment
  extends ReportV4Fragment
{
  protected String getAppId()
  {
    return ((MiniAppActivity)getActivity()).mAppId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.ui.MiniAppBaseFragment
 * JD-Core Version:    0.7.0.1
 */