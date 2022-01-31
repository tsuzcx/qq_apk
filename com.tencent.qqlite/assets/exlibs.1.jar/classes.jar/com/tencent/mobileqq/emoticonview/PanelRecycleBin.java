package com.tencent.mobileqq.emoticonview;

import android.view.View;
import java.util.ArrayList;

public class PanelRecycleBin
{
  private static final int jdField_a_of_type_Int = 3;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public PanelRecycleBin()
  {
    this.a = new ArrayList();
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public View a()
  {
    if (this.a.size() > 0) {
      return (View)this.a.remove(0);
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(View paramView)
  {
    if (this.a.size() >= 3) {
      return;
    }
    this.a.add(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PanelRecycleBin
 * JD-Core Version:    0.7.0.1
 */