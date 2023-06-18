package io.github.romvoid95.scg.database.modal;

import java.util.ArrayList;
import java.util.List;

import com.christophecvb.elitedangerous.models.Pack;

import lombok.Data;

@Data
public class FleetCarrierData
{
    private String carrierId = "";
    private String callsign = "";
    private String vanityName = "";
    private String currentStarSystem = "";
    private int    fuel = 0;
    private Services services = new Services();

    @Data
    public static class Services
    {
        private final Refuel                 refuel                 = new Refuel();
        private final Repair                 reapir                 = new Repair();
        private final Armoury                armoury                = new Armoury();
        private final RedemptionOffice       redemptionOffice       = new RedemptionOffice();
        private final Shipyard               shipyard               = new Shipyard();
        private final Outfitting             outfitting             = new Outfitting();
        private final SecureWarehouse        secureWarehouse        = new SecureWarehouse();
        private final UniversalCartographics universalCartographics = new UniversalCartographics();
        private final ConcourseBar           concourseBar           = new ConcourseBar();
        private final VistaGenomics          vistaGenomics          = new VistaGenomics();
        private final PioneerSupplies        pioneerSupplies        = new PioneerSupplies();

        @Data
        public static class Refuel
        {
            private boolean active  = false;
            private int     taxRate = 0;
        }

        @Data
        public static class Repair
        {
            private boolean active  = false;
            private int     taxRate = 0;
        }

        @Data
        public static class Armoury
        {
            private boolean active  = false;
            private int     taxRate = 0;
        }

        @Data
        public static class RedemptionOffice
        {
            private boolean active = false;
        }

        @Data
        public static class Shipyard
        {
            private boolean    active    = false;
            private int        taxRate   = 0;
            private List<Pack> shipPacks = new ArrayList<>();
        }

        @Data
        public static class Outfitting
        {
            private boolean    active      = false;
            private int        taxRate     = 0;
            private List<Pack> modulePacks = new ArrayList<>();
        }

        @Data
        public static class SecureWarehouse
        {
            private boolean active  = false;
            private int     taxRate = 0;
        }

        @Data
        public static class UniversalCartographics
        {
            private boolean active = false;
        }

        @Data
        public static class ConcourseBar
        {
            private boolean active = false;
        }

        @Data
        public static class VistaGenomics
        {
            private boolean active = false;
        }

        @Data
        public static class PioneerSupplies
        {
            private boolean active  = false;
            private int     taxRate = 0;
        }
    }
}
