package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.cs.cmd0x383.cmd0x383.FileTimestamp;

public class TroopFileManager$FileTimestamp
{
  public int a;
  public String a;
  
  public static void a(FileTimestamp paramFileTimestamp, cmd0x383.FileTimestamp paramFileTimestamp1)
  {
    if (paramFileTimestamp == null)
    {
      paramFileTimestamp1.uint32_upload_time.set(0);
      paramFileTimestamp1.str_file_path.set("");
    }
    for (;;)
    {
      paramFileTimestamp1.setHasFlag(true);
      return;
      paramFileTimestamp1.uint32_upload_time.set(paramFileTimestamp.jdField_a_of_type_Int);
      paramFileTimestamp1.str_file_path.set(paramFileTimestamp.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.FileTimestamp
 * JD-Core Version:    0.7.0.1
 */