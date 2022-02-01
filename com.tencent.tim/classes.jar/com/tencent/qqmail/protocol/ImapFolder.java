package com.tencent.qqmail.protocol;

import java.io.Serializable;

public class ImapFolder
  implements Serializable
{
  public static int FA_INVALID = 4;
  public static int FA_MARKED = 0;
  public static int FA_NO_INFERIORS = 0;
  public static int FA_NO_SELECT = 0;
  public static int FA_UNMARKED = 0;
  private static final long serialVersionUID = 1L;
  public int[] attribute_list_;
  public String hierarchy_delimiter_;
  public boolean junk_folder_;
  public String parent_path_;
  public String path_;
  public String show_name_;
  public String title_;
  
  static
  {
    FA_NO_INFERIORS = 1;
    FA_MARKED = 2;
    FA_UNMARKED = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ImapFolder
 * JD-Core Version:    0.7.0.1
 */