using System;
using System.Collections.Generic;
using System.Data.Entity.Core.Common.CommandTrees.ExpressionBuilder;
using System.Linq;
using System.Security.Cryptography;
using System.Web;
using System.Web.Mvc;
using System.Web.UI.WebControls;
using Lab9.Models;
using PagedList.Mvc;



namespace Lab9.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        IEnumerable<Log> GetLogs()
        {
            using(DBModelLogs db = new DBModelLogs())
            {
                var logs = db.Logs.ToList();
                return logs;
            }

        }

        public ActionResult GetAll()
        {

            using (DBModelLogs db = new DBModelLogs())
            {
               
                var data = db.Logs.ToList();
                ViewBag.result = data;


            }


            return View(GetLogs());
        }


        public ActionResult AddOrEdit()
        {
            Log logg = new Log();
            return View(logg);
        }
        [HttpPost]
        public ActionResult AddOrEdit(Log log)
        {
            using(DBModelLogs db = new DBModelLogs())
            {
                db.Logs.Add(log);
                db.SaveChanges();
            }


            return RedirectToAction("GetAll");
        }

        public ActionResult Delete(int id)
        {
            using(DBModelLogs db = new DBModelLogs())
            {
                return View(db.Logs.Where(x => x.logID == id).FirstOrDefault());

            }
        }

        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                using(DBModelLogs db = new DBModelLogs())
                {
                    Log log = db.Logs.Where(x => x.logID == id).FirstOrDefault();
                    db.Logs.Remove(log);
                    db.SaveChanges();
                }
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}