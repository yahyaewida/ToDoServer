package todolistserver.model;

/**
 *
 * @author Ibrahim
 */
public interface DatabaseQueries {
    //user
    String LOGIN_USER_QUERY = "SELECT * FROM USERS";
    String REGISTER_USER_QUERY = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
    String RETRIEVE_USERS_QUERY = "SELECT * FROM USERS";
    String RETRIEVE_USER_FRIENDS = "SELECT * FROM FRIENDLIST WHERE USERID = ?";
    
    //todos
    String INSERT_TODO_LIST_QUERY = "INSERT INTO TODOLIST VALUES(?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_TODO_LIST_QUERY = "UPDATE TODOLIST SET TITLE = ?, DESCRIPTION = ?, DEADLINEDATE = ?, ASSIGNINGDATE = ?, BACKGROUNDCOLOR = ?, STATUS = ? WHERE TODOID = ?";
    String DELETE_TODO_LIST_QUERY = "DELETE FROM TODOLIST WHERE TODOID = ?";
    String RETRIEVE_ALL_TODO_LISTS_QUERY = "SELECT * FROM TODOLIST WHERE CREATORID = ?";
    
    //items
    String INSERT_ITEM_QUERY = "INSERT INTO ITEM VALUES(?, ?, ?, ?, ?)";
    String UPDATE_ITEM_QUERY = "UPDATE ITEM SET TITLE = ?, DESCRIPTION = ? TODOID = ?, CREATORID = ?, DEADLINE = ? WHERE ITEMID = ?";
    String DELETE_ITEM_QUERY = "DELETE FROM ITEM WHERE ITEMID = ?";
    String RETRIEVE_ALL_ITEMS_QUERY = "SELECT * FROM ITEM WHERE TODOID = ?"; 
    
    //collaborator 
    String ASSIGN_FRIEND_TO_iTEM = "INSERT INTO ITEMASSIGNEDUSERS VALUES(?, ?)";
    String RERIEVE_ALL_FRIENDS_ASSIGNED_TO_iTEM = "SELECT U.* FROM USERS AS U, TODOList AS T, TODOLISTUSERS AS TU, ITEM AS I, ITEMASSIGNEDUSERS AS IAU WHERE  IAU.userID = U.USERID and TU.userID = U.userID and Tu.todoID = T.todoID and I.todoID = T.todoID  and  IAU.itemID = I.itemID  and T.todoID=? and I.itemID =?";
    String ASSIGN_FRIEND_TO_TODOLIST = "INSERT INTO TODOLISTUSERS VALUES(?, ?)";
    String RETRIEVE_ALL_FRIEND_ASSIGNED_TO_TODOLIST = "SELECT u.* FROM USERS AS U, TODOList AS T, TODOLISTUSERS AS TU WHERE  TU.userID = U.userID and Tu.todoID = T.todoID  and  T.todoID=?";
    String DELETE_FRIEND_ON_ITEM="DELETE FROM itemAssignedUsers WHERE ITEMID= ?";
    String GET_USERID_BY_USERNAME = "SELECT * FROM USERS WHERE USERNAME = ?";
    String CHECK_IF_USER_FRIEND = "SELECT * FROM FRIENDLIST WHERE FRIENDID = ? AND USERID = ?";


    //notification
   String INSERT_NOTIFICATION_QUERY = "INSERT INTO NOTIFICATIONS VALUES(?, ?, ?, ?)";
   String RETRIEVE_USER_NOTIFICATIONS="select n.notificationID from notifications as n , notificationReceivers as nr where n.notificationID = nr.notificationID and nr.receiverID = ?";
    


}

