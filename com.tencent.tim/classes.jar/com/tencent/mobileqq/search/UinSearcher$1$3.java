package com.tencent.mobileqq.search;

import aesy.a;
import amks;
import amkt;
import amow;
import anot;
import ausj;
import com.tencent.mobileqq.app.QQAppInterface;

public class UinSearcher$1$3
  implements Runnable
{
  public UinSearcher$1$3(amkt paramamkt, ausj paramausj, amow[] paramArrayOfamow1, amow[] paramArrayOfamow2, aesy.a parama, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.val$actionSheet.show();
    String str1;
    String str2;
    if (this.jdField_a_of_type_ArrayOfAmow[0] == null) {
      if (this.b[0] == null)
      {
        str1 = "0X800A923";
        if ((this.jdField_a_of_type_ArrayOfAmow[0] != null) || (this.b[0] != null)) {
          break label127;
        }
        str2 = "";
      }
    }
    for (;;)
    {
      anot.a(this.val$app, "dc00898", "", "", str1, str1, amks.c(this.val$app, amks.b(this.jdField_a_of_type_Amkt.a), amks.d(this.jdField_a_of_type_Amkt.a)), 0, str2, "", "", "");
      return;
      str1 = "0X800A921";
      break;
      if (this.b[0] == null)
      {
        str1 = "0X800A920";
        break;
      }
      str1 = "0X800A922";
      break;
      label127:
      if (this.jdField_a_of_type_Aesy$a.ahM()) {
        str2 = aesy.a.cOY + "";
      } else {
        str2 = aesy.a.cOZ + "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.3
 * JD-Core Version:    0.7.0.1
 */