package com.tencent.open.agent;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import artl;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;
import java.util.List;

public abstract class OpenFrame
  extends InnerFrame
{
  protected artl a;
  public InnerFrameManager a;
  public FriendChooser b;
  protected QQAppInterface e;
  protected LayoutInflater mLayoutInflater;
  
  public OpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public List<Friend> gP()
  {
    ArrayList localArrayList = new ArrayList(50);
    int i = 0;
    while (i < this.jdField_a_of_type_Artl.Ng())
    {
      localArrayList.addAll(this.jdField_a_of_type_Artl.ao(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public abstract void notifyDataSetChanged();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ((FriendChooser)super.getActivity());
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = super.a();
    this.e = super.b();
    this.mLayoutInflater = this.b.getLayoutInflater();
    this.jdField_a_of_type_Artl = artl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenFrame
 * JD-Core Version:    0.7.0.1
 */