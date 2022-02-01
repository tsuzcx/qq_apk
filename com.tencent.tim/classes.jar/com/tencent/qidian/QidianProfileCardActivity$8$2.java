package com.tencent.qidian;

import asic;
import com.tencent.image.URLImageView;
import java.util.concurrent.ConcurrentHashMap;

class QidianProfileCardActivity$8$2
  implements Runnable
{
  QidianProfileCardActivity$8$2(QidianProfileCardActivity.8 param8, asic paramasic, URLImageView paramURLImageView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Asic.type == 1) {}
    for (String str = this.jdField_a_of_type_Asic.faceUrl;; str = this.jdField_a_of_type_Asic.uin)
    {
      this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$8.this$0.jC.put(this.jdField_a_of_type_Asic.uin, new QidianProfileCardActivity.b(this.ce, this.jdField_a_of_type_Asic.type, str));
      this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$8.this$0.a(this.jdField_a_of_type_Asic.type, this.ce, str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.8.2
 * JD-Core Version:    0.7.0.1
 */