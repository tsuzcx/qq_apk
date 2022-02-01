package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleInitBean;
import java.util.ArrayList;
import java.util.List;
import oum;
import ovg;
import ovr;
import owc;
import oww;
import oxd;
import oxh;
import oxo;
import oxv;
import pco;
import pcr;
import rxk;

public class QCircleTagPageFragment
  extends QCircleBaseFragment
{
  private QCircleInitBean a;
  private List<rxk> lu;
  
  private void Ie()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean"))) {
      this.a = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
    }
  }
  
  public List<rxk> bw()
  {
    Ie();
    if (this.lu == null)
    {
      this.lu = new ArrayList();
      this.lu.add(new oxv(this.a));
      Object localObject = new ArrayList();
      ((List)localObject).add(new ovr(null));
      ((List)localObject).add(new ovg(new Bundle()));
      localObject = new oxo((List)localObject, 3, 1);
      ((oxo)localObject).a(this.a);
      this.lu.add(localObject);
      localObject = new oxh();
      this.lu.add(localObject);
      localObject = new oxd(oum.a());
      this.lu.add(localObject);
      if ((this.a != null) && (this.a.getTagInfo() != null)) {
        ((oxd)localObject).setTagInfo(this.a.getTagInfo());
      }
      ((oxd)localObject).nA(5);
      localObject = new owc();
      this.lu.add(localObject);
      ((owc)localObject).rf(true);
      this.lu.add(new oww());
    }
    return this.lu;
  }
  
  public int getContentLayoutId()
  {
    return 2131560953;
  }
  
  public String getLogTag()
  {
    return "QCircleTagPageFragment";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    pco.h("", 6, 1L);
    if (pcr.a().ey(31)) {
      pcr.a().aX(getActivity().getIntent());
    }
  }
  
  public void onBackPressed()
  {
    pcr.a().vq(31);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment
 * JD-Core Version:    0.7.0.1
 */