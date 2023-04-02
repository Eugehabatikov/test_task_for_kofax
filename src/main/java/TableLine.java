public class TableLine {
    String DEL_FLAG;
    String SEED_VERSION_ADDED;
    String SEED_VERSION_UPDATED;
    String PREFERENCE_NAME;
    String DESCRIPTION;
    String SYSTEM_LEVEL_YN;
    String GROUP_LEVEL_YN;
    String USER_LEVEL_YN;
    String CHANGEABLE_YN;
    String PREFERENCE_DOMAIN_NAME;
    String USE_DEFAULT_VALUE_YN;
    String DEFAULT_VALUE;
    String GROUP_LEVEL_PRIORITY_YN;
    int GROUP_RESOLUTION_METHOD;
    String PRESERVE_ON_UPGRADE_YN;
    String MODULE_NAME;
    String ORG_LEVEL_YN;

    public TableLine(String[] cells) {
        DEL_FLAG = cells[0];
        SEED_VERSION_ADDED = cells[1];
        SEED_VERSION_UPDATED = cells[2];
        PREFERENCE_NAME = cells[3];
        DESCRIPTION = cells[4];
        SYSTEM_LEVEL_YN = cells[5];
        GROUP_LEVEL_YN = cells[6];
        USER_LEVEL_YN = cells[7];
        CHANGEABLE_YN = cells[8];
        PREFERENCE_DOMAIN_NAME = cells[9];
        USE_DEFAULT_VALUE_YN = cells[10];
        DEFAULT_VALUE = cells[11];
        GROUP_LEVEL_PRIORITY_YN = cells[12];
        GROUP_RESOLUTION_METHOD = Integer.parseInt(cells[13]);
        PRESERVE_ON_UPGRADE_YN = cells[14];
        MODULE_NAME = cells[15];
        ORG_LEVEL_YN = cells[16];
    }

    public static String inputValue(TableLine value) {
        return "'" + value.DEL_FLAG + "','" +
                value.SEED_VERSION_ADDED  + "','" +
                value.SEED_VERSION_UPDATED  + "','" +
                value.PREFERENCE_NAME  + "','" +
                value.DESCRIPTION  + "','" +
                value.SYSTEM_LEVEL_YN  + "','" +
                value.GROUP_LEVEL_YN  + "','" +
                value.USER_LEVEL_YN  + "','" +
                value.CHANGEABLE_YN  + "','" +
                value.PREFERENCE_DOMAIN_NAME  + "','" +
                value.USE_DEFAULT_VALUE_YN   + "','" +
                value.DEFAULT_VALUE  + "','" +
                value.GROUP_LEVEL_PRIORITY_YN  + "'," +
                value.GROUP_RESOLUTION_METHOD  + ",'" +
                value.PRESERVE_ON_UPGRADE_YN  + "','" +
                value.MODULE_NAME  + "','" +
                value.ORG_LEVEL_YN  + "'";
    }
}
