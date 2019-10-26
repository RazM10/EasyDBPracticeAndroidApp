package org.richit.easydbpractice;

import android.content.Context;
import android.database.Cursor;

import p32929.androideasysql_library.Column;
import p32929.androideasysql_library.EasyDB;

public class DummyDatabase {
    private static EasyDB easyDB;

    public static void init(Context context) {
        if (easyDB == null)
            easyDB = EasyDB.init(context, "CLASS") // "TEST" is the name of the DATABASE
                    .setTableName("DEMO TABLE")  // You can ignore this line if you want
                    .addColumn(new Column("Name", "text", "unique")) // Contrains like "text", "unique", "not null" are not case sensitive
                    .addColumn(new Column("Seat", "text", "not null"))
                    .addColumn(new Column("Floor", "text"))
                    .doneTableColumn();
    }

    public static boolean addData(String name, String seat, String floor) {
        return easyDB.addData(1, name)
                .addData(2, seat)
                .addData(3, floor)
                .doneDataAdding();
    }

    public static String getAllData() {
        String s = "";
        Cursor res = easyDB.getAllData();
        while (res.moveToNext()) {
            String aName = res.getString(1);
            String aSeat = res.getString(2);
            String aFloor = res.getString(3);
            s += aName + " " + aSeat + " " + aFloor;
            s += "\n";
        }

        return s;
    }
}
