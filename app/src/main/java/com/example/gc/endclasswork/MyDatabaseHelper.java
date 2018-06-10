package com.example.gc.endclasswork;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 龚 聪 on 2018/6/10.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context mContext;
    public static final String CREATE_User = "create table user(" +
            //primary key 将usename列设为主键
            "username text primary key ," +
            "password text," +
            "tel text)";
    public static final String Insert_User = "Insert into User values("
            +"'gongcong', '123456', 15871610393)";

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public  MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory , int version){
        super(context,name ,factory,version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //调用SQLiteDatabase中的execSQL（）执行建表与插入语句。
        db.execSQL(CREATE_User);
        db.execSQL(Insert_User);
        //创建成功
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
