package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import java.util.ArrayList;
import java.util.List;
import ptf;
import pxs;
import pxs.a;
import pxs.b;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(ptf paramptf, String paramString, pxs.b paramb, pxs.a parama) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.atK, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Pxs$b.c = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Pxs$a.c(this.jdField_a_of_type_Pxs$b);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new QQUserUIItem.a("", this.atK));
    new pxs(this.jdField_a_of_type_Pxs$a).B(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */