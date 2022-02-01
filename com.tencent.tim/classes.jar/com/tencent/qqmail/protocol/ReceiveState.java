package com.tencent.qqmail.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

public class ReceiveState
  implements Serializable
{
  public static final int FMActiveHeartBeatActived = 0;
  public static final int FMActiveHeartBeatBacground = 1;
  private static final long serialVersionUID = 1L;
  public int accountId;
  public boolean active_sync_complete_;
  public int active_sync_filter_type = 3;
  public boolean active_sync_heartbeat;
  public int active_sync_heartbeat_type;
  public int available_count_;
  public boolean check_repeat_;
  public int complete_folder_count_;
  public int count_of_sync;
  public String[] deleted_pop_mail_list_;
  public int download_size;
  public int download_start_pos;
  public int[] empty_vector_;
  public ProtocolFolder[] exchange_folder_list_;
  public HashMap<String, Boolean> exist_map_;
  public int failed_count_;
  public int folderId;
  public String folderName;
  public String folder_name_;
  public String folder_remoteId;
  public boolean high_priority_;
  public int[] imap_download_uid_;
  public boolean is_archive_folder_root;
  public boolean is_html;
  public boolean is_load_content_part_;
  public boolean is_search;
  public boolean is_search_all;
  public OnProtocolListener listener;
  public boolean load_sent_contact_;
  public String localDocumentPath;
  public long mailId;
  public double mailSearchTime;
  public double mailTimeStamp;
  public String mail_list_criteria_;
  public String operation;
  public int pop_top_lines_;
  public int push_download_text_;
  public boolean receive_head_only_;
  public int receive_mail_count_of_load_more_;
  public HashMap<String, HashMap<String, Boolean>> received_uid_exist_map_;
  public boolean recv_limited_count_;
  public boolean recv_new_only_;
  public int repeat_count_;
  public boolean search_action;
  public boolean stop_loading_;
  public int success_count_;
  public int total_count_;
  public Map.Entry<Integer, String[]>[] uid_section_list;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ReceiveState
 * JD-Core Version:    0.7.0.1
 */