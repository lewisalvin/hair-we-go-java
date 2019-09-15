package org.launchcode.hairwegospring.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class HairDAO {

    private static final List<styleType> hair = new ArrayList<styleType>();

    static {
        initData();
    }

    private static void initData() {
        styleType ta = new styleType(1L, "3A", "3A");
        styleType tb = new styleType(2L, "3B", "3B");
        styleType tc = new styleType(3L, "3C", "3C");
        styleType fa = new styleType(4L, "4A", "4A");
        styleType fb = new styleType(5L, "4B", "4B");
        styleType fc = new styleType(6L, "4C", "4C");

        hair.add(ta);
        hair.add(tb);
        hair.add(tc);
        hair.add(fa);
        hair.add(fb);
        hair.add(fc);
    }

    public List<styleType> getHairTypes() {
        return hair;
    }

    //public String PersonForm

    public Long findByTypeId(Long typeId) {
        return typeId;
    }

    public Map<Long, String> getMapCountries() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (styleType c : hair) {
            map.put(c.getTypeId(), c.getTypeName());
        }
        return map;
    }
}
